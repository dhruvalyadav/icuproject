# IblivAngular

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 19.0.6.

## Development server

To start a local development server, run:

```bash
ng serve
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.



<app-alert [message]="message" [type]="alerttype" [show]="alertmode" (closed)="alertmode = false"></app-alert>
<div class="spinner-box" *ngIf="mainspinner">
  <div class="spinner-gradient"></div>
</div>
<div class="container mt-4" *ngIf="!mainspinner" >
  <h3 class="form-label">Patient Medication Chart</h3>
  <form #patmedicationchart="ngForm">
    <div class="row mb-3">
      <div class="col-md-6">
          <label for="patientdaysheet" class="form-label">Date*</label>
          <select name="patidaysheet" class="form-control" [(ngModel)]="sheetid" required>
            <option *ngFor="let patientsheet of patientdaysheets" value="{{patientsheet.patientdaysheetid}}">{{patientsheet.date?.toString()?.split("T")}}</option>
          </select>
      </div>
    </div>
    <div class="row mb-3">
        <div class="col-md-6">
            <label for="ventilator" class="form-label">ventilator mode*</label>
            <select name="ventilator" class="form-control" [(ngModel)]="ventilatorid" required>
              <option *ngFor="let ven of ventilators" value="{{ven.ventilatormodeid}}">{{ven.ventilatormode}}</option>
            </select>
        </div>
      </div>
    <div class="row mb-3">
        <div class="col-md-6">      
          <label for="fio2">fio2*</label>
          <input type="number" required class="form-control"  name="fio2" placeholder="Enter fio2" [(ngModel)]="patientventilator.fio2">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">      
          <label for="peepcpap">peepcpap*</label>
          <input type="number" class="form-control" required  name="peepcpap" placeholder="Enter peepcpap" [(ngModel)]="patientventilator.peepcpap">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">      
          <label for="rate">rate*</label>
           <input type="number" class="form-control" required  name="rate" placeholder="Enter rate" [(ngModel)]="patientventilator.rate">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="tv">tv*</label>
            <input type="number" class="form-control" name="tv" required  [(ngModel)]="patientventilator.tv">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="ppeak">ppeak*</label>
            <input type="number" class="form-control" name="ppeak" required  [(ngModel)]="patientventilator.ppeak">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="mv">mv*</label>
            <input type="number" class="form-control" name="mv" required  [(ngModel)]="patientventilator.mv">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="spo2">spo2*</label>
            <input type="number" class="form-control" name="spo2" required  [(ngModel)]="patientventilator.spo2">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="cuffpressure">cuffpressure*</label>
            <input type="number" class="form-control" name="cuffpressure" required  [(ngModel)]="patientventilator.cuffpressure">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="epap">epap*</label>
            <input type="number" class="form-control" name="epap" required  [(ngModel)]="patientventilator.epap">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="peakinsppressure">peakinsppressure*</label>
            <input type="number" class="form-control" name="peakinsppressure" required  [(ngModel)]="patientventilator.peakinsppressure">
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-md-6">
             <label for="spo2">plateaupressure*</label>
            <input type="number" class="form-control" name="plateaupressure" required  [(ngModel)]="patientventilator.plateaupressure">
        </div>
      </div>
      <div class="spinner-gradient" *ngIf="spin"></div>
    <button type="submit" *ngIf="!spin" class="add-patient-btn" (click)="addventilator(patmedicationchart)">Update Measurements</button>
  </form>
</div>