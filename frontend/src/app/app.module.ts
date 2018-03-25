import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ExampleComponent } from './example/example.component';
import { SharedModule } from "./shared/shared.module";
import { AppRoutingModule } from "./app.routing";
import { ExampleAddDialogComponent } from './example/example-add-dialog/example-add-dialog.component';
import { ExampleEditDialogComponent } from './example/example-edit-dialog/example-edit-dialog.component';
import { ReactiveFormsModule } from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
    ExampleComponent,
    ExampleAddDialogComponent,
    ExampleEditDialogComponent
  ],
  imports: [
    BrowserModule,
    SharedModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  entryComponents: [
    ExampleAddDialogComponent,
    ExampleEditDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
