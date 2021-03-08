import { Component, OnInit } from '@angular/core';
import {User} from '../User';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.scss']
})
export class CreateUserComponent implements OnInit {

  username = '';
  password = '';
  accessLevel = '';
  user: User[] = [];
  url = '/api/users';
  baseUrl: string = 'http://localhost:8080/EducanetWebik/api/users';

  constructor(private router: Router, private http: HttpClient, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

  send() {
    const body = {
      username: this.username,
      password: this.password,
      accessLevel: this.accessLevel
    };

    console.log(this.username);
    this.http.post(this.url, body, {observe: 'response'}).subscribe((data) => {
      console.log(data);
      this.router.navigate(['/users']);

    });
  }

}
