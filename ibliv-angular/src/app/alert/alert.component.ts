import { Component , Input, Output , EventEmitter} from '@angular/core';

@Component({
  selector: 'app-alert',
  standalone: false,
  templateUrl: './alert.component.html',
  styleUrl: './alert.component.scss'
})
export class AlertComponent {
  @Input() type: 'success' | 'error' | 'warning' | 'info' = 'info' ;
  @Input() message: string = '';
  @Input() show : boolean|null=null
  @Output() closed = new EventEmitter<void>()

  get icon(): string {
    return {
      success: '✓',
      error: '⚠',
      warning: '⚠',
      info: 'i'
    }[this.type];
  }

  close(){
    this.show = false
    this.closed.emit()
  }
}
