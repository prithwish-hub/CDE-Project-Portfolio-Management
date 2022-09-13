import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from '../services/auth.service';
import {
  mutualFundsDetails,
  NetWorthService,
  stockDetails,
} from '../services/net-worth.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css'],
})
export class PortfolioComponent implements OnInit {
  isLoading: boolean = false;
  error = null;
  userId: string = '';
  netWorth: number = 0;
  stocks: stockDetails[] = [];
  mutualFunds: mutualFundsDetails[] = [];
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
        this.netWorth = response.netWorth;
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

  getNoOfStocks(): number {
    let noOfStocks = 0;
    for (let x of this.stocks) {
      noOfStocks += x.stockCount;
    }
    return noOfStocks;
  }

  getNoOfMutualFunds(): number {
    let noOfMutualFunds = 0;
    for (let x of this.mutualFunds) {
      noOfMutualFunds += x.mutualFundUnits;
    }
    return noOfMutualFunds;
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }

  handleError() {
    this.error = null;
    this.router.navigate(['/services']);
  }
}
