import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-url',
  standalone: false,
  
  templateUrl: './url.component.html',
  styleUrl: './url.component.scss'
})
export class UrlComponent {
    @Input() links : any[] = []
}
