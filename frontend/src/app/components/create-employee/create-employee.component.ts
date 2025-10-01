import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
})
export class CreateEmployeeComponent {
  form = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    age: [null, [Validators.required, Validators.pattern(/^\d+$/)]],
    role: [''],
    salary: [null, [Validators.required, Validators.pattern(/^\d+(\.\d{1,2})?$/)]],
    hireDate: ['', Validators.required],
    endDate: [''],
    departmentId: [null, Validators.required]
  });

  constructor(private fb: FormBuilder, private service: EmployeeService) {}

  submit() {
    const deptId = this.form.value.departmentId;
    const data = { ...this.form.value };
    delete data.departmentId;

    this.service.createEmployee(deptId!, data).subscribe({
      next: () => alert('Empleado creado con éxito'),
      error: () => alert('Error al crear empleado')
    });
  }
}