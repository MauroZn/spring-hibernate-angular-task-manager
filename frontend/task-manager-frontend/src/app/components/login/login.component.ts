import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login({ username: this.username, password: this.password }).subscribe({
      next: (response) => {
        localStorage.setItem('jwtToken', response.token);
        this.router.navigate(['/tasks']);
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Invalid credentials';
      }
    });
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }
}
