import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customers',
  standalone: false,

  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  customers :any
  constructor(private  Http: HttpClient , private  router : Router) {
  }
  ngOnInit(): void {
    this.Http.get("http://localhost:1124/CUSTOMER-SERVICE/customers").subscribe({
      next : (data) =>{
        this.customers = data
        console.log(this.customers)
      },
      error : (err) =>{

      }
    });
  }
  getBilling(p: any) {
    this.router.navigateByUrl("/billing/"+p.id);
    console.log(p.id);
  }
}
