import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  standalone: false,
  
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  tabs = [
    { id: 1, label: 'Dashboard', icon: 'bx-home' },
    { id: 2, label: 'Patients', icon: 'bx-user' },
    { id: 3, label: 'Appointments', icon: 'bx-calendar' },
    { id: 4, label: 'Medications', icon: 'bx-capsule' },
    { id: 5, label: 'Reports', icon: 'bx-file' },
    { id: 6, label: 'Settings', icon: 'bx-cog' }
  ];
  
  activeTab = 1;
  
  selectTab(tabId: number) {
    this.activeTab = tabId;
    // Add your tab content change logic here
  }
}
