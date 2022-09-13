import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { FeaturesComponent } from './features/features.component';
import { PortfolioComponent } from './portfolio/portfolio.component';
import { AlertModalComponent } from './common/alert-modal/alert-modal.component';
import { AuthService } from './services/auth.service';
import { AuthGuard } from './services/auth.guard';
import { NetWorthService } from './services/net-worth.service';
import { AuthTokenInterceptorService } from './services/auth-token-interceptor.service';
import { SellAssetComponent } from './sell-asset/sell-asset.component';
import { LoadingSpinnerComponent } from './common/loading-spinner/loading-spinner.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    FeaturesComponent,
    PortfolioComponent,
    AlertModalComponent,
    SellAssetComponent,
    LoadingSpinnerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    AuthService,
    AuthGuard,
    NetWorthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthTokenInterceptorService,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
