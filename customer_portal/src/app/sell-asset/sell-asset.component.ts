import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from '../services/auth.service';
import {
  assetSaleRequest,
  mutualFundsDetails,
  NetWorthService,
  stockDetails,
} from '../services/net-worth.service';

@Component({
  selector: 'app-sell-asset',
  templateUrl: './sell-asset.component.html',
  styleUrls: ['./sell-asset.component.css'],
})
export class SellAssetComponent implements OnInit {
  isLoading: boolean = false;
  error: string | null = null;
  success: string | null = null;
  userId: string = '';
  stocks: stockDetails[] = [];
  mutualFunds: mutualFundsDetails[] = [];
  value: number = 0;
  userSubscription: Subscription = new Subscription();

  constructor(
    private authService: AuthService,
    private netWorthService: NetWorthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.userSubscription = this.authService.user.subscribe((user) => {
      if (user) this.userId = user.userId;
    });
    this.isLoading = true;
    this.netWorthService.getNetWorth(this.userId).subscribe(
      (response) => {
        this.isLoading = false;
        this.stocks = response.stocks;
        this.mutualFunds = response.mutualFunds;
      },
      (err) => {
        this.isLoading = false;
        this.error = err.error.message
          ? err.error.message
          : 'Something went wrong.  Please try again later.';
      }
    );
  }

  makeSellRequest(request: assetSaleRequest) {
    this.isLoading = true;
    this.netWorthService.sellAssets(request).subscribe(
      (response) => {
        this.isLoading = false;
        if (response.saleStatus) {
          this.success =
            'Assets sold successfully! Your current net worth is ' +
            response.netWorth;
        } else {
          this.error = 'Something went wrong. Please try again later';
        }
      },
      (err) => {
        this.isLoading = false;
        this.error = err.error.message
          ? err.error.message
          : 'Something went wrong.  Please try again later.';
      }
    );
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }

  onSubmit(event: any) {
    let _stocks: stockDetails[] = [];
    let _mutualFunds: mutualFundsDetails[] = [];
    for (let [index, value] of this.stocks.entries()) {
      let x: stockDetails = {
        stockName: value.stockName,
        stockCount: event.target[`stock_${index}`].value
          ? event.target[`stock_${index}`].value
          : 0,
      };
      if (x.stockCount > value.stockCount) {
        this.error = 'You can not sell more than what you have';
        return;
      }
      _stocks.push(x);
    }
    for (let [index, value] of this.mutualFunds.entries()) {
      let x: mutualFundsDetails = {
        mutualFundName: value.mutualFundName,
        mutualFundUnits: event.target[`mf_${index}`].value
          ? event.target[`mf_${index}`].value
          : 0,
      };
      if (x.mutualFundUnits > value.mutualFundUnits) {
        this.error = 'You can not sell more than what you have';
        return;
      }
      _mutualFunds.push(x);
    }
    let request: assetSaleRequest = {
      userId: this.userId,
      stocks: _stocks,
      mutualFunds: _mutualFunds,
    };
    this.makeSellRequest(request);
  }

  handleError() {
    this.error = null;
    this.router.navigate(['/services']);
  }

  handleSuccess() {
    this.success = null;
    this.router.navigate(['/portfolio']);
  }
}
