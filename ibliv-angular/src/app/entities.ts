export class Anthropometry {
  createdby: number=0;
  createddate: Date|null=null;
  updateddate: Date|null=null;
  anthropometryid: number|null=null;
  patient: Patient=new Patient;
  weight: number=0;
  height: number=0;
  bmi: number=0;
  bsaboyd: number=0;
  updatedby: number=0;

  constructor() {}
}

export class Applicationversion {
  createdby: number=0;
  createddate: Date|null=null;
  updateddate: Date|null=null;
  versionid: number|null=null;
  versionnumber: string='';
  active: number=0;
  updatedby: number=0;

  constructor() {}
}

export class Consultantpatientvisit {
  consultantpatientvisitid: number|null=null;
  datetime: Date|null=null;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;
  doctor: User=new User;

  constructor() {}
}

export class Division {
  divisionid: number|null=null;
  divisionname: string='';
  divisioncode: string='';
  date: Date|null=null;
  active: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  roleList: Role[]=[];

  constructor() {}
}

export class Embolism {
  embolismid: number|null=null;
  dvtrisk: string='';
  anticoagulation: string='';
  compression: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;

  constructor() {}
}

export class Hourlyobservation {
  hourlyobservationid: number|null=null;
  timeslot: number=0;
  value: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;
  vital: Vital=new Vital;

  constructor() {}
}

export class Icu {
  icuid: number|null=null;
  name: string='';
  active: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  constructor() {}
}

export class Ivfluid {
  ivfluidid: number|null=null;
  ivfluidname: number=0;
  active: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientivfluidList: Patientivfluid[]=[];

  constructor() {}
}

export class Linestubes {
  linestubesid: number|null=null;
  linestubesname: number=0;
  active: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientlinestubesList: Patientlinestubes[]=[];

  constructor() {}
}

export class Menudetails {
  menuid: number|null=null;
  mainname: string='';
  subname: string='';
  link: string='';
  classname: string='';
  mainsort: number=0;
  subsort: number=0;
  active: number=0;
  ionicactive: number=0;
  mainicon: string='';
  subicon: string='';
  ionicdashboardicon: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  roleaccessList: Roleaccess[]=[];

  constructor() {}
}


export class Patient {
  dob: Date = new Date();
  patientname : string = ''
  createdby: number=0;
  createddate: Date|null=null;
  updateddate: Date|null=null;
  patientid: number = 0;
  age: number=0;
  sex: string='';
  address: string='';
  contact: string='';
  active: number=0;
  updatedby: number=0;
  constructor() {}
}

export class Patientadditionalscores {
  patientadditionalscoresid: number|null=null;
  qsofa: number=0;
  mews: number=0;
  apacheiv: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;

  constructor() {}
}

export class Patientadditionaltests {
  patientadditionaltestsid: number|null=null;
  ambulation: string='';
  incentivespirometry: string='';
  belt: string='';
  dressing: string='';
  trachettsectretion: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;
  physiothearpy: Physiothearpy=new Physiothearpy;

  constructor() {}
}

export class Patientadmission {
  patientadmissionid: number|null=null;
  admissiondate: Date|null=null;
  icuadmissiondate: Date|null=null;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  icu: Icu=new Icu;
  patient: Patient=new Patient;

  constructor() {}
}

export class Patientdaysheet {
  patientdaysheetid: number|null=null;
  date: Date|null=null;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientadmission: Patientadmission=new Patientadmission;
  consultant1: User=new User;
  consultant2: User=new User;
  consultant3: User=new User;
  intensivist: User=new User;
  constructor() {}
}

export class Patientinfusion {
  patientinfusionid: number|null=null;
  time: Date|null=null;
  fluidname: string='';
  fluidvolume: string='';
  ivmedication: string='';
  dose: string='';
  rate: string='';
  starttime: Date|null=null;
  endtime: Date|null=null;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patient: Patient=new Patient;
  preparedby: User=new User;

  constructor() {}
}

export class Patientivfluid {
  patientivfluidid: number|null=null;
  rate: string='';
  additionaldrugs: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  ivfluid: Ivfluid=new Ivfluid;
  patient: Patient=new Patient;

  constructor() {}
}

export class Patientlinestubes {
  patientlinestubesid: number|null=null;
  dateofinsertion: Date|null=null;
  site: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  linestubes: Linestubes=new Linestubes;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;

  constructor() {}
}

export class Patientmedicationchart {
  patientmedicationchartid: number|null=null;
  drug: string='';
  date: Date|null=null;
  dose: string='';
  route: string='';
  frequency: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientadmission: Patientadmission=new Patientadmission;
  patientmedicationlogList: Patientmedicationlog[]=[];

  constructor() {}
}

export class Patientmedicationlog {
  patientmedicationlogid: number|null=null;
  drug: string='';
  date: Date|null=null;
  dose: string='';
  route: string='';
  administrationtime: Date|null=null;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientmedicationchart: Patientmedicationchart=new Patientmedicationchart;
  administeredby: User=new User;

  constructor() {}
}

export class Patientsosmedication {
  patientsosmedicationid: number|null=null;
  indication: string='';
  drug: string='';
  dose: string='';
  route: string='';
  time: Date|null=null;
  telephoneverbal: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patient: Patient=new Patient;
  administeredby: User=new User;
  orderedbydoctor: User=new User;

  constructor() {}
}

export class Patientventilator {
  patientventilatorid: number|null=null;
  fio2: number=0;
  peepcpap: number=0;
  rate: number=0;
  tv: number=0;
  ppeak: number=0;
  mv: number=0;
  spo2: number=0;
  cuffpressure: number=0;
  epap: number=0;
  peakinsppressure: number=0;
  plateaupressure: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;
  ventilatormode: Ventilatormode=new Ventilatormode;

  constructor() {}
}

export class Physiothearpy {
  physiothearpyid: number|null=null;
  physiothearpy: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientadditionaltestsList: Patientadditionaltests[]=[];

  constructor() {}
}

export class Resettoken {
  resettokenid: number|null=null;
  token: string='';
  date: Date|null=null;
  user: User=new User;

  constructor() {}
}

export class Rmonurselog {
  rmonurselogid: number|null=null;
  datetime: Date|null=null;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientdaysheet: Patientdaysheet=new Patientdaysheet;
  rmonurse: User=new User;

  constructor() {}
}

export class Role {
  roleid: number|null=null;
  name: string='';
  rolecode: string='';
  description: string='';
  active: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  division: Division=new Division;
  roleaccessList: Roleaccess[]=[];
  userroleList: Userrole[]=[];

  constructor() {}
}

export class Roleaccess {
  roleaccessid: number|null=null;
  ionicmenu: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  menu: Menudetails=new Menudetails;
  role: Role=new Role;

  constructor() {}
}

export class Shiftrmonurse {
  shiftrmonurseid: number|null=null;
  date: Date|null=null;
  shift: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  icu: Icu=new Icu;
  rmo: User=new User;
  nurse: User=new User;

  constructor() {}
}

export class User {
  userid: number|null=null;
  name: string='';
  id: string='';
  mobileno: string='';
  email: string='';
  active: number=0;
  username: string='';
  password: string='';
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;

  constructor() {}
}

export class Userrole {
  userroleid: number|null=null;
  active: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  role: Role=new Role;
  user: User=new User;

  constructor() {}
}

export class Usertoken {
  usertokenid: number|null=null;
  token: string='';
  fcmtoken: string='';
  datetime: Date|null=null;
  user: User=new User;

  constructor() {}
}

export class Ventilatormode {
  ventilatormodeid: number|null=null;
  ventilatormode: string='';
  active: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  patientventilatorList: Patientventilator[]=[];

  constructor() {}
}

export class Vital {
  vitalid: number|null=null;
  vitalname: string='';
  vitalcategory: string='';
  active: number=0;
  categorysortorder: number=0;
  sortorder: number=0;
  createdby: number=0;
  createddate: Date|null=null;
  updatedby: number=0;
  updateddate: Date|null=null;
  hourlyobservationList: Hourlyobservation[]=[];

  constructor() {}
}
export class submenu{
  subname : string = '';
  link : string = '';
  subsort : number = 0
  subicon : string = '';
}

export class menu {
   label: string = '';
   link: string = '';
   mainicon:string = '';
   mainsort : number = 0;
   subitems : submenu[] = [];
   isOpen: boolean = false;
}

export class Admissionstatus{
  patientadmission : Patientadmission|null=null
  addedstatus : boolean|null=null
}