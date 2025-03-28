import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true, 
  imports: [FormsModule, CommonModule, HttpClientModule], 
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private http: HttpClient) {}

  onSubmit() {
    const url = 'http://localhost:8080/auth';
    const credentials = {
      username: this.username,
      password: this.password
    };

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    this.http.post(url, credentials, httpOptions)
      .pipe(
        catchError(error => {
          console.error('Error en el inicio de sesión:', error);
          alert('Error en el inicio de sesión. Por favor, inténtalo de nuevo.');
          return throwError(error);
        })
      )
      .subscribe((response: any) => {
        if (response && response.token) {
          alert('Inicio de sesión exitoso');
          // Aquí se redirige al dashboard o la siguiente operacion
        } else {
          alert('Credenciales incorrectas');
        }
      });
  }
}