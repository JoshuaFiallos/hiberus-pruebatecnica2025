import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-metrics',
  templateUrl: './metrics.component.html',
})
export class MetricsComponent {
  highestSalary: any;
  youngestEmployee: any;
  countLastMonth: any;

  constructor(private service: EmployeeService) {}

  getHighestSalary() {
    this.service.getHighestSalary().subscribe(res => this.highestSalary = res);
  }

  getLowestAge() {
    this.service.getLowestAge().subscribe(res => this.youngestEmployee = res);
  }

  getCountLastMonth() {
    this.service.countLastMonth().subscribe(res => this.countLastMonth = res);
  }
}