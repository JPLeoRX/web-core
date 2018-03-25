import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ExampleService} from "./services/example.service";
import {MaterialModule} from "./modules/material.module";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],

  exports: [
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],

  declarations: [

  ],
  providers: [
    ExampleService
  ]
})
export class SharedModule { }
