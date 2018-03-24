import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {map} from "rxjs/operators";
import {Example} from "../models/example.model";

/**
 * Sample Angular service to send REST requests to the backend
 *
 * @author Leo Ertuna
 * @since 24.03.2018 20:11
 */
@Injectable()
export class ExampleService {


  constructor(private http: HttpClient) { }

  getAllExamples(): Observable<Example[]> {
    // REST request
    return this.http.get<any>( '/api/example/getAll').pipe(map(response => {
      // If response is valid
      if (response.success && response.results) {
        // Return result obtained from back-end
        return response.results.examples;
      }
    }));
  }

  addExample(example: Example): Observable<Example> {
    // Extract data and prepare it for passing as JSON
    let data = {
      text: example.text
    };

    // REST request
    return this.http.post<any>('/api/example/add', data).pipe(map(response => {
      // If response is valid
      if (response.success && response.results) {
        // Return result obtained from backend
        return response.results.example;
      }
    }));
  }

  updateExample(example: Example): Observable<Example> {
    // Extract data and prepare it for passing as JSON
    let data = {
      exampleId: example.exampleId,
      text: example.text,
      createdAt: example.createdAt
    };

    // REST request
    return this.http.put<any>('/api/example/update', data).pipe(map(response => {
      // If response is valid
      if (response.success && response.results) {
        // Return result obtained from backend
        return response.results.example;
      }
    }));
  }

  deleteExample(example: Example) : Observable<Example> {
    // REST request
    return this.http.delete<any>('/api/example/delete/' + example.exampleId).pipe(map(response => {
      // If response is valid
      if (response.success && response.results) {
        // Return note obtained from backend
        return response.results.example;
      }
    }));
  }
}
