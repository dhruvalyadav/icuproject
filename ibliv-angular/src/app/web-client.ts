import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { inject, Injectable } from "@angular/core";
import { environment } from "../environments/environment";
import { firstValueFrom } from "rxjs";

@Injectable({ providedIn: 'root' })
export class WebClient
{
  private http = inject(HttpClient);
  private TOKEN: string | null = null;

  public get<T>(url: string)
  {
    const headers: any = {};
    if (this.TOKEN) headers['token'] = this.TOKEN;
    return firstValueFrom(this.http.get<T>(environment.BASE_URL + url, { headers: headers }));
  }
  public getAll<T>(url: String): Observable<T>
  {
    let headers: any = {};
    if (this.TOKEN) headers['token'] = this.TOKEN;
    return this.http.get<T>(environment.BASE_URL + url, { headers: headers });

  }
  public post<T, U>(url: string, data: T)
  {
    const headers: any = {};
    if (this.TOKEN) headers['token'] = this.TOKEN;
    return firstValueFrom(this.http.post<U>(environment.BASE_URL + url, data, { headers: headers }));
  }
  public delete<T>(url: string)
  {
    const headers: any = {};
    if (this.TOKEN) headers['token'] = this.TOKEN;
    return firstValueFrom(this.http.delete<T>(environment.BASE_URL + url, { headers: headers }));
  }
  public put<T, U>(url: string, data: T)
  {
    const headers: any = {};
    if (this.TOKEN) headers['token'] = this.TOKEN;
    return firstValueFrom(this.http.put<U>(environment.BASE_URL + url, data, { headers: headers }));
  }
  public patch<T, U>(url: string, data: T)
  {
    const headers: any = {};
    if (this.TOKEN) headers['token'] = this.TOKEN;
    return firstValueFrom(this.http.patch<U>(environment.BASE_URL + url, data, { headers: headers }));
  }
}
