import { Component, HostListener, IterableDiffers, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WebClient } from '../web-client';
import { Menudetails, menu, submenu } from '../entities';


@Component({
  selector: 'app-menu',
  standalone: false,
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent implements OnInit{
  isMenuOpen = false;
  constructor(private router: Router,private webclient : WebClient) {}

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  sidemenubaritems : menu[] = []

  ngOnInit(): void {
    this.webclient.getAll<Menudetails[]>("getallmenuitems").subscribe(
      (response)=>{
        response.map((res)=>{
          if(res.subname!='' && this.findsidemenubar(res.mainsort)){
            const singleitem : menu = { label: res.mainname, link: res.link, mainicon: res.mainicon,mainsort : res.mainsort, subitems : [],isOpen: false}
            response.filter((item)=>{return item.mainsort==res.mainsort}).map((subitem)=>{
              const subsingleitem : submenu = {subname : subitem.subname,link : subitem.link,subicon : subitem.subicon,subsort : subitem.subsort}
              singleitem.subitems.push(subsingleitem)
            })
            this.sidemenubaritems.push(singleitem)
          } else if(res.subname==''){
            const singleitem : menu = { label: res.mainname, link: res.link, mainicon: res.mainicon,mainsort : res.mainsort, subitems : [],isOpen: false}
            this.sidemenubaritems.push(singleitem)
          }
        })
      },(error)=>{}
    )
  }

  findsidemenubar(name : number){
    return this.sidemenubaritems.filter((res)=>{return res.mainsort==name}).length > 0 ? false : true
  }

  isActive(link: string): boolean {
    return this.router.isActive(link, false);
  }

  navigateTo(link: string): void {
    this.router.navigate([link]);
    if (window.innerWidth < 768) {
      this.isMenuOpen = false;
    }
  }

  navigateToHome(): void {
    this.router.navigate(['/']);
  }

  logout(): void {
    this.router.navigate(['/login']);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: Event): void {
    const target = event.target as Window;
    if (target.innerWidth < 768) {
      this.isMenuOpen = false;
    } else {
      this.isMenuOpen = true;
    }
  }

  toggleDropdown(menu :HTMLElement,item: any) {
    item.isOpen = !item.isOpen;
    if(item.isOpen==true){
      menu.style.flexDirection = 'column';
    } else {
      menu.style.flexDirection = 'row'
    }
  }
  openform(operation : string){
  }
}


/*
INSERT INTO menudetails (`mainname`,`subname`,`link`,`classname`,`mainsort`,`subsort`,`active`,`ionicactive`,`mainicon`,`subicon`,`createdby`,`createddate`,`updatedby`,`updateddate`) 
VALUES ('Patient details','daysheet','/patient/daysheet','Patient-details',4,4,1,1,'personal_injury','today',1,NOW(),1,NOW());*/