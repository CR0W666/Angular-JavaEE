import { Component, OnInit } from '@angular/core';
import {User} from '../User';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private http: HttpClient, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }
  url = '/api/users';
  baseUrl: string = 'http://localhost:8080/EducanetWebik/api/users';
  testUsername: string = "test lol";
  createUser() {
    const body = {
      name: this.testUsername
    }
    this.http.post(this.url, body, {observe: 'response'}).subscribe((data) => {
      console.log(data);
      


    });
  }

}
