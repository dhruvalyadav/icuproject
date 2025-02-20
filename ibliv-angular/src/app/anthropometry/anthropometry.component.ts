import { Anthropometry } from './../entities';
import { Component } from '@angular/core';

@Component({
  selector: 'app-anthropometry',
  standalone: false,

  templateUrl: './anthropometry.component.html',
  styleUrl: './anthropometry.component.scss'
})
export class AnthropometryComponent {
  anthropometry=new Anthropometry;

  
}
