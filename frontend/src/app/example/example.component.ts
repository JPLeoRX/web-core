import { Component, OnInit } from '@angular/core';
import {Example} from "../shared/models/example.model";
import {ExampleService} from "../shared/services/example.service";
import {MatDialog} from "@angular/material";
import {ExampleAddDialogComponent} from "./example-add-dialog/example-add-dialog.component";
import {ExampleEditDialogComponent} from "./example-edit-dialog/example-edit-dialog.component";

/**
 * Overview of items
 *
 * Has a list of items and two buttons
 *
 * @author Leo Ertuna
 * @since 25.03.2018 18:56
 */
@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.css']
})
export class ExampleComponent implements OnInit {

  // Items to display
  private _examples: Example[];

  constructor(
    private _service: ExampleService,
    private _dialog: MatDialog
  ) { }



  // Initialization
  //--------------------------------------------------------------------------------------------------------------------
  ngOnInit() {
    this.initExamples();
  }

  private initExamples(): void {
    // Get examples from the service
    this._service.getAllExamples().subscribe((examples: Example[]) => {
      this._examples = examples;
    });
  }
  //--------------------------------------------------------------------------------------------------------------------



  // Buttons
  //--------------------------------------------------------------------------------------------------------------------
  /**
   * When add button is clicked
   */
  onAddClick(): void {
    // Open new dialog
    let dialogRef = this._dialog.open(ExampleAddDialogComponent, {
      data: {}
    });

    // After dialog is closed
    dialogRef.afterClosed().subscribe((exampleAdded: Example) => {
      // If it was successfully added
      if (exampleAdded) {
        // Add this to the view (unshift adds to the beginning, push adds to the end)
        this._examples.push(exampleAdded);
      }
    });
  }

  /**
   * When delete button is clicked
   */
  onDeleteClick(example: Example): void {
    // If valid
    if (example) {
      // Delete from the backend
      this._service.deleteExample(example).subscribe((exampleDeleted: Example) => {
        // Remove from the view
        this._examples = this._examples.filter( (e: Example) => {
          return e.exampleId !== exampleDeleted.exampleId;
        });
      });
    }
  }

  /**
   * When edit button is clicked
   */
  onEditClick(example: Example): void {
    // If valid
    if (example) {
      // Open new dialog
      let dialogRef = this._dialog.open(ExampleEditDialogComponent, {
        // Pass example to it
        data: {example: example}
      });

      // After dialog is closed
      dialogRef.afterClosed().subscribe((exampleUpdated: Example) => {
        // If it was successfully updated
        if (exampleUpdated) {
          // Update it in the view
          this._examples = this._examples.filter( (e: Example) => {
            // If this item was updated
            if (e.exampleId === exampleUpdated.exampleId)
              // Change its text
              e.text = exampleUpdated.text;

            // Filter all elements as true
            return true;
          });
        }
      });
    }
  }

  /**
   * When delete all button is clicked
   */
  onDeleteAllClick(): void {
    // Delete from the backend
    this._service.deleteAllExamples().subscribe((examplesDeleted: Example[]) => {
      // Empty the view
      this._examples = [];
    });
  }
  //--------------------------------------------------------------------------------------------------------------------



  // Getters
  //--------------------------------------------------------------------------------------------------------------------
  get examples(): Example[] {
    return this._examples;
  }
  //--------------------------------------------------------------------------------------------------------------------
}
