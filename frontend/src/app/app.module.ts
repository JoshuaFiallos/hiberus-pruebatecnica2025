import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { MetricsComponent } from './components/metrics/metrics.component';

@NgModule({
  declarations: [AppComponent, CreateEmployeeComponent, MetricsComponent],
  imports: [BrowserModule, ReactiveFormsModule, HttpClientModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }