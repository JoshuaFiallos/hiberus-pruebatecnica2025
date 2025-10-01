import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class EmployeeService {
  private api = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  createEmployee(deptId: number, data: any): Observable<any> {
    return this.http.post(`${this.api}/employee/create/${deptId}`, data);
  }

  getHighestSalary(): Observable<any> {
    return this.http.get(`${this.api}/employee/highestSalary`);
  }

  getLowestAge(): Observable<any> {
    return this.http.get(`${this.api}/employee/lowerAge`);
  }

  countLastMonth(): Observable<any> {
    return this.http.get(`${this.api}/employee/countLastMonth`);
  }
}