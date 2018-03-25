import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ExampleAddDialogComponent} from "../example-add-dialog/example-add-dialog.component";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {ExampleService} from "../../shared/services/example.service";
import {ValidateHelper} from "../../shared/helpers/validate.helper";
import {Example} from "../../shared/models/example.model";

/**
 * Dialog to edit item
 *
 * Has two buttons and a reactive form
 *
 * @author Leo Ertuna
 * @since 25.03.2018 18:56
 */
@Component({
  selector: 'app-example-edit-dialog',
  templateUrl: './example-edit-dialog.component.html',
  styleUrls: ['./example-edit-dialog.component.css']
})
export class ExampleEditDialogComponent implements OnInit {

  // The form
  exampleEditForm: FormGroup;

  constructor(
    private _dialogRef: MatDialogRef<ExampleAddDialogComponent>,
    private _service: ExampleService,
    private _formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }



  // Initialization
  //--------------------------------------------------------------------------------------------------------------------
  ngOnInit() {
    this.initForm();
  }

  private initForm(): void {
    this.exampleEditForm = this._formBuilder.group({
      text: [this.data.example.text, [Validators.required, Validators.maxLength(1024), Validators.pattern(/\S/u)]]
    });
  }
  //--------------------------------------------------------------------------------------------------------------------



  // Buttons
  //--------------------------------------------------------------------------------------------------------------------
  /**
   * When the close button is clicked
   */
  onCloseClick(): void {
    // Simply close the dialog
    this._dialogRef.close();
  }

  /**
   * When the save button is clicked
   */
  onSaveClick(): void {
    // If form is not valid
    if (!this.exampleEditForm.valid) {
      // Enable all validation messages
      ValidateHelper.validateAllFormFields(this.exampleEditForm);

      // Return from this method
      return;
    }

    // If the form is valid
    else {
      // Extract data from form
      const formModel = this.exampleEditForm.value;

      // Load object and fill it with updated data
      const exampleToUpdate = this.data.example;
      exampleToUpdate.text = formModel.text;

      // Save new object
      this._service.updateExample(exampleToUpdate).subscribe(
        // If saved successfully
        (exampleUpdated: Example) => {
          // Close the dialog with passing the saved object
          this._dialogRef.close(exampleUpdated);
        },

        // If an error occurred
        (error) => {
          console.error(error);
        });
    }
  }
  //--------------------------------------------------------------------------------------------------------------------
}
