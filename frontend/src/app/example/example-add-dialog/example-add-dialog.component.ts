import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {ExampleService} from "../../shared/services/example.service";
import {Example} from "../../shared/models/example.model";
import {ValidateHelper} from "../../shared/helpers/validate.helper";
import {ExampleForm} from "../../shared/models/example-form.model";

/**
 * Dialog to add new items
 *
 * Has two buttons and a reactive form
 *
 * @author Leo Ertuna
 * @since 25.03.2018 18:56
 */
@Component({
  selector: 'app-example-add-dialog',
  templateUrl: './example-add-dialog.component.html',
  styleUrls: ['./example-add-dialog.component.css']
})
export class ExampleAddDialogComponent implements OnInit {

  // The form
  exampleAddForm: FormGroup;

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
    this.exampleAddForm = this._formBuilder.group({
      text: ['', [Validators.required, Validators.maxLength(1024), Validators.pattern(/\S/u)]]
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
    if (!this.exampleAddForm.valid) {
      // Enable all validation messages
      ValidateHelper.validateAllFormFields(this.exampleAddForm);

      // Return from this method
      return;
    }

    // If the form is valid
    else {
      // Extract data from form
      const formModel = this.exampleAddForm.value;

      // Create new object and fill it with data
      const exampleToAdd = new ExampleForm(formModel.text);

      // Save new object
      this._service.addExample(exampleToAdd).subscribe(
        // If saved successfully
        (exampleAdded: Example) => {
          // Close the dialog with passing the saved object
          this._dialogRef.close(exampleAdded);
        },

        // If an error occurred
        (error) => {
          console.error(error);
        });
    }
  }
  //--------------------------------------------------------------------------------------------------------------------
}
