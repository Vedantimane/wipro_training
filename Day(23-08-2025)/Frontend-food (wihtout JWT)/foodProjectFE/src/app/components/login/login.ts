import { Component, OnInit } from '@angular/core';
import { UserLoginService } from '../../services/user-login-service';
import { User } from '../../interface/user';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  userEmail: string = '';
  userPassword: string = '';
  errorMessage: string = '';

  constructor(
    private userLoginService: UserLoginService,
    private router: Router
  ) {}

  onLogin() {
    this.userLoginService.login(this.userEmail, this.userPassword).subscribe({
      next: (user: User | null) => {
        if (user && user.userEmail) {
          // ✅ Successful login
          localStorage.setItem('loggedInUser', JSON.stringify(user));
          this.router.navigate(['/foodList']);
        } else {
          // ❌ Wrong credentials
          this.errorMessage = 'Invalid email or password!';
          alert(this.errorMessage);   // 🔔 Popup alert
        }
      },
      error: () => {
        this.errorMessage = 'Login failed! Please try again.';
        alert(this.errorMessage);    // 🔔 Popup alert
      }
    });
  }
}