import {
  MatAutocompleteModule, MatButtonModule, MatCardModule, MatCheckboxModule, MatDialogModule, MatExpansionModule,
  MatFormFieldModule, MatIconModule, MatInputModule, MatRadioModule, MatSelectModule, MatTooltipModule
} from "@angular/material";
import { NgModule } from "@angular/core";

@NgModule({
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatCheckboxModule,
    MatRadioModule,
    MatExpansionModule,
    MatIconModule,
    MatDialogModule,
    MatAutocompleteModule,
    MatTooltipModule,
    MatCardModule
  ],
  exports: [
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatCheckboxModule,
    MatRadioModule,
    MatExpansionModule,
    MatIconModule,
    MatDialogModule,
    MatAutocompleteModule,
    MatTooltipModule,
    MatCardModule
  ],
})
export class MaterialModule {

}
