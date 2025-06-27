import { Component, OnInit,Input,TemplateRef } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';

interface Column {
  header: string;
  field: string;
  sortable? : boolean;
  template : TemplateRef<any>;
}
@Component({
  selector: 'app-url',
  standalone: false,
  
  templateUrl: './url.component.html',
  styleUrl: './url.component.scss'
})
export class UrlComponent implements OnInit{
  patientid : Number = 0
  constructor(private route:Router,private router : ActivatedRoute,private webclient : WebClient){}

  ngOnInit(): void {
    this.patientid = Number(this.router.snapshot.paramMap.get("id"))     

  }
  hours : any[] = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24]
  temperatures : any[] = [71,37,47,55,51,72]
}
