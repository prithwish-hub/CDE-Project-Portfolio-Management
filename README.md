
# CDE-Project-Portfolio-Management

This project is a part of Cognizant Technology Solution Ltd's internship program. 

A leading Financial Services Organization wants to strengthen its Middleware by exposing the core logic related to Portfolio Management as Microservices. This middle ware Microservices will be hosted on Cloud so that all the up/downstream applications can get an access to this for performing business transactions.

There will also be a customer Portal to be developed part of this scope that consumes these Microservices to view their portfolio information and sell their assets.



## Installation

Install customer_portal with npm

```bash
  cd customer_portal
  npm install
```

Run customer_portal with npm. By default it will run on localhost:4200

```bash
  ng serve
``` 

Import authorizationMicroservice, calculateNetworthMicroservice, dailyMutualFundNAVMicroservice and dailySharePriceMicroservice in your IDE.

You can run the applications by executing the main mathods of these microservices.

Alternatively you can use the Spring Boot Maven plugin like so:

```bash
  mvn spring-boot:run
``` 
authorizationMicroservice runs on localhost:8081
dailySharePriceMicroservice runs on localhost:8082
dailyMutualFundNAVMicroservice runs on localhost:8083
calculateNetworthMicroservice runs on localhost:8084


## Authorization Microservice API Reference

#### Login

```http
  POST /auth-service/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `AuthRequest` | `object` | **Required**. Login credentials of the user |

#### Validate

```http
  GET /auth-service/validate
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `jwtToken`      | `string` | **Required**. Jwt token to check its validity |

## Daily Share Price Microservice API Reference

#### Stock details by name

```http
  GET /share-price-service/dailySharePrice/{stockName}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `stockName` | `string` | **Required**. Name of the stock |
| `jwtToken` | `string` | **Required**. Jwt token of the user |

## Daily Mutual Fund NAV Microservice API Reference

#### Mutual fund details by name

```http
  GET /mutual-fund-price-service/mutualFundNav/{mutualFundName}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `mutualFundName` | `string` | **Required**. Name of the mutual fund |
| `jwtToken` | `string` | **Required**. Jwt token of the user |

## Calculate Net Worth Microservice API Reference

#### Calculate net worth

```http
  GET /net-worth-service/calculateNetworth/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Required**. Id of the user |
| `jwtToken` | `string` | **Required**. Jwt token of the user |

#### Sell assets

```http
  POST /net-worth-service/sellAssets
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `assetSaleRequest` | `object` | **Required**. Details of asset to sell |
| `jwtToken` | `string` | **Required**. Jwt token of the user |

## Tech Stack

**Client:** Angular, Bootstrap

**Server:** Spring Boot, MySql, Docker


## Screenshots

#### Home Page
![App Screenshot](https://raw.githubusercontent.com/prithwish-hub/CDE-Project-Portfolio-Management/main/Screenshots/home_page.png)

#### Login Page
![App Screenshot](https://raw.githubusercontent.com/prithwish-hub/CDE-Project-Portfolio-Management/main/Screenshots/login_page.png)

#### Services Page
![App Screenshot](https://raw.githubusercontent.com/prithwish-hub/CDE-Project-Portfolio-Management/main/Screenshots/services_page.png)

#### Portfolio Dashboard Page
![App Screenshot](https://raw.githubusercontent.com/prithwish-hub/CDE-Project-Portfolio-Management/main/Screenshots/portfolio_dashboard_page.png)

#### Sell Assets Page
![App Screenshot](https://raw.githubusercontent.com/prithwish-hub/CDE-Project-Portfolio-Management/main/Screenshots/sell_assets_page.png)

#### Sell Assets Page (No Assets)
![App Screenshot](https://raw.githubusercontent.com/prithwish-hub/CDE-Project-Portfolio-Management/main/Screenshots/sell_assets_page_with_no_assets.png)

