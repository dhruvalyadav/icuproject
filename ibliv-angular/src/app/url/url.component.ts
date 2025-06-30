import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WebClient } from '../web-client';

@Component({
  selector: 'app-url',
  standalone: false,

  templateUrl: './url.component.html',
  styleUrls: ['./url.component.scss']
})
export class UrlComponent implements OnInit {
  patientid: number=0;

  constructor(private route: ActivatedRoute, private webclient: WebClient) {}

  formatLabel(key: string): string {
  return key
      .replace(/([a-z])([A-Z])/g, '$1 $2')
      .replace(/_/g, ' ')
      .replace(/\b\w/g, l => l.toUpperCase());
  }

  ngOnInit(): void {
  this.route.paramMap.subscribe(params => {
    const idParam = params.get('id');
    const patientId = idParam ? +idParam : 0;
      
    if (patientId > 0) {
      this.loadInfusionTable();
      this.loadScoreTable();
    }
  });
  }

  // infusion Table 
  infusionData: any[]=[];
  infusionColumns: {key:string; label: string}[] = [];
  loadInfusionTable(): void {
    this.webclient.getAll<any[]>(`patientinfusion?patientid=${this.patientid}`).subscribe(data => {
      this.infusionData = data;
      if (data.length > 0) {
        this.infusionColumns = Object.keys(data[0])
          .filter(key => typeof data[0][key] !== 'object')
          .map(key => ({
            key,
            label: this.formatLabel(key)
          }));
      }
    });
  }
  isValid(data : any[]): boolean {
    return Array.isArray(data) && data.length > 0;
  }

  //patient additional scores
  scoreData: any[]=[];
  scoreColumns: {key: string; label:string }[]= [];
  scoreDisplayColumns: string[] = [ 'qsofa', 'mews', 'apacheiv'];

  loadScoreTable(): void {
    this.webclient.getAll<any[]>(`patientadditionalscores?patientid=${this.patientid}`).subscribe(data => {
      this.scoreData = data;
      if (data.length > 0) {
        this.scoreColumns = this.scoreDisplayColumns.map(key => ({
          key,
          label: this.formatLabel(key)
        }));
      }
    });
  }

  getValue(obj: any, path: string): any {
    return path.split('.').reduce((acc, part) => acc && acc[part], obj);
  }

}
