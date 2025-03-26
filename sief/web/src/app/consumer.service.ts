import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsumerService {
  private apiUrl = 'http://localhost:8080/login'; // URL del microservicio
  

  constructor(private http: HttpClient) { }

  fetchData(body: any) {
    return this.http.request("POST",this.apiUrl,{body: body,headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })});
  }
}