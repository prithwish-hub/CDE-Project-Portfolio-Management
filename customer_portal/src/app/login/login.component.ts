import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  isLoading: boolean = false;
  error: null = null;
  userSubscription: Subscription = new Subscription();
  loginInputs = this.formBuilder.group({
    username: '',
    password: '',
  });

  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.userSubscription = this.authService.user.subscribe((user) => {
      if (user) this.router.navigate(['/services']);
    });
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }

  login(username: string | any, password: string | any) {
    this.isLoading = true;
    this.authService.login({ username, password }).subscribe(
      (res) => {
        this.isLoading = false;
        this.error = null;
        this.router.navigate(['/services']);
      },
      (err) => {
        this.isLoading = false;
        this.error = err.error.message
          ? err.error.message
          : 'Something went wrong. Please try again later.';
      }
    );
  }

  onSubmit() {
    this.login(
      this.loginInputs.value.username,
      this.loginInputs.value.password
    );
    this.loginInputs.reset();
  }

  handleError() {
    this.error = null;
  }
}
