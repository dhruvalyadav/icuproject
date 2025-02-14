import { Injectable } from "@angular/core";
import { User } from "./entities";

@Injectable({providedIn: 'root'})
export class Appdata
{
  loggedInUser:User|null=null;
}
