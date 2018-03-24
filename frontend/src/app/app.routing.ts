import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import {ExampleComponent} from "./example/example.component";


const appRoutes: Routes = [
  { path: 'example', component: ExampleComponent},
  { path: '', redirectTo: '/example', pathMatch: 'full' },
  { path: '**', redirectTo: '' }
];


@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
