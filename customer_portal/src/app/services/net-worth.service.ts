import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

export interface stockDetails {
  stockName: string;
  stockCount: number;
}

export interface mutualFundsDetails {
  mutualFundName: string;
  mutualFundUnits: number;
}

export interface netWorthResponse {
  portfolioId: string;
  stocks: stockDetails[];
  mutualFunds: mutualFundsDetails[];
  netWorth: number;
}

export interface assetSaleRequest {
  userId: string;
  stocks: stockDetails[];
  mutualFunds: mutualFundsDetails[];
}

export interface assetSaleResponse {
  saleStatus: boolean;
  netWorth: number;
}

@Injectable({
  providedIn: 'root',
})
export class NetWorthService {
  constructor(private http: HttpClient) {}

  public getNetWorth(userId: string): Observable<netWorthResponse> {
    return this.http.get<netWorthResponse>(
      environment.NET_WORTH_SERVICE_URL + '/calculateNetworth/' + userId
    );
  }

  public sellAssets(request: assetSaleRequest): Observable<assetSaleResponse> {
    return this.http.post<assetSaleResponse>(
      environment.NET_WORTH_SERVICE_URL + '/sellAssets',
      request
    );
  }
}
