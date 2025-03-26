import { Component } from '@angular/core';
import { ConsumerService } from '../../consumer.service';
import { FormsModule } from '@angular/forms';
import { HttpParams } from '@angular/common/http';


@Component({
  selector: 'app-login',
  standalone: true, 
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports:[FormsModule]
})

export class LoginComponent {
  userName: string = "";
  password: string = "";

  constructor(private dataService: ConsumerService) { }

  loginMethod() {
    const body = {
      name: this.userName,
      password: this.password
    };

    console.log('Llamada al servidor ',body);
    this.dataService.fetchData(body).subscribe(
      response => {
        console.log('Exito al contactar', response);
        // Manejar la respuesta del servidor
      },
      error => {
        console.error('Error al contactar al servidor', error);
        // Manejar el error
      }
    );
  }
}