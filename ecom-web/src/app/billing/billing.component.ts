import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-billing',
  standalone: false,
  templateUrl: './billing.component.html',
  styleUrl: './billing.component.css'
})
export class BillingComponent implements OnInit{
  billing : any;
  customerId! : any;
  constructor(private http:HttpClient , private router : Router , private  route: ActivatedRoute) {
    this.customerId =route.snapshot.params['customerId']
  }

  ngOnInit(): void {
    console.log(this.customerId);
    this.http.get(`http://localhost:1124/BILLING-SERVICE/bills/search/byCustomerId?customerId="+${this.customerId}`).subscribe({
      next : (data) =>{
        this.billing = data
        console.log(this.billing)
      },
      error : (err) =>{

      }
    });
  }

}
