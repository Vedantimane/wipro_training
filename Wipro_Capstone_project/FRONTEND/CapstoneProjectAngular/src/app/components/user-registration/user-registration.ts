import { Component } from '@angular/core';
import { UserRegistrationnService } from '../../services/user-registrationn-service';
import { Router } from '@angular/router';
import { UserInterface } from '../../interface/user-interface';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-registration',
  imports: [FormsModule, CommonModule],
  templateUrl: './user-registration.html',
  styleUrl: './user-registration.css'
})
export class UserRegistration {
user: UserInterface = {
    firstname: '',
    lastName: '',
    email: '',
    passWord: '',
    address: ''
  };

  constructor(private userService: UserRegistrationnService, private router: Router) {}
onRegister() {
  console.log('User Registration Data:', this.user); // log to console

  this.userService.registerUser(this.user).subscribe({
    next: (res) => {
      console.log('Backend Response:', res); // log response from backend
      alert('User registered successfully');
      // optionally navigate to login page after registration
      this.router.navigate(['/demo']);
    },
    error: (err) => {
      console.error('Registration failed:', err);
      alert('Registration failed');
    }
  });
}
}