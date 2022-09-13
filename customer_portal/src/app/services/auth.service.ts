import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, Subject, tap } from 'rxjs';
import { environment } from '../../environments/environment.prod';
import { User } from './user.model';

interface AuthResponse {
  userId: string;
  username: string;
  jwtToken: string;
  serverCurrentTime: number;
  tokenExpirationTime: number;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  user = new BehaviorSubject<User | null>(null);
  timeout = new Subject<boolean>();
  private tokenExpirationTime: any;

  constructor(private http: HttpClient, private router: Router) {}

  login(loginInputs: {
    username: string;
    password: string;
  }): Observable<AuthResponse> {
    return this.http
      .post<AuthResponse>(environment.AUTH_SERVICE_URL + '/login', loginInputs)
      .pipe(
        tap((res) =>
          this.handleAuthentication(
            res['userId'],
            res['username'],
            res['jwtToken'],
            res['serverCurrentTime'],
            res['tokenExpirationTime']
          )
        )
      );
  }

  private handleAuthentication(
    userId: string,
    username: string,
    jwtToken: string,
    serverCurrentTime: number,
    tokenExpirationTime: number
  ) {
    const user = new User(
      userId,
      username,
      jwtToken,
      serverCurrentTime,
      tokenExpirationTime
    );
    this.storeUser(user);
    this.user.next(user);
  }

  autoLogin() {
    const user = localStorage.getItem('user');
    if (!user) return;

    const parsedUser: {
      userId: string;
      username: string;
      jwtToken: string;
      serverCurrentTime: number;
      tokenExpirationTime: number;
    } = JSON.parse(user);

    const loadedUser = new User(
      parsedUser.userId,
      parsedUser.username,
      parsedUser.jwtToken,
      parsedUser.serverCurrentTime,
      parsedUser.tokenExpirationTime
    );

    if (loadedUser.jwtToken) {
      this.user.next(loadedUser);
      const expirationDuration =
        loadedUser.tokenExpirationTime - new Date().getTime();
      this.autoLogout(expirationDuration);
    }
  }

  autoLogout(duration: number) {
    this.tokenExpirationTime = setTimeout(() => {
      this.timeout.next(true);
      this.logout();
    }, duration);
  }

  logout() {
    this.user.next(null);
    this.removeUser();
    if (this.tokenExpirationTime) {
      clearTimeout(this.tokenExpirationTime);
    }
    this.tokenExpirationTime = null;
    this.router.navigate(['/login']);
  }

  private storeUser(user: User) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  private removeUser() {
    localStorage.removeItem('user');
  }
}
