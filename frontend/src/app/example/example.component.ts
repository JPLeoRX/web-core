import { Component, OnInit } from '@angular/core';
import {Example} from "../shared/models/example.model";
import {ExampleService} from "../shared/services/example.service";

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.css']
})
export class ExampleComponent implements OnInit {

  private _examples: Example[];

  constructor(private _service: ExampleService) { }

  ngOnInit() {
    // Get examples from the service
    this._service.getAllExamples().subscribe((examples: Example[]) => {
      this._examples = examples;
    });
  }


  get examples(): Example[] {
    return this._examples;
  }
}
