import { Component, OnInit,Input,TemplateRef } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-url',
  standalone: false,
  
  templateUrl: './url.component.html',
  styleUrl: './url.component.scss'
})
export class UrlComponent{
  @Input() tableData: any[] = [];
  @Input() columns: { key: string, label: string }[] = [];
  @Input() tableTitle: string = '';

  getValue(obj: any, path: string): any {
  return path.split('.').reduce((acc, part) => acc && acc[part], obj);
}

}
