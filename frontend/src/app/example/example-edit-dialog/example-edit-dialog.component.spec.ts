import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExampleEditDialogComponent } from './example-edit-dialog.component';

describe('ExampleEditDialogComponent', () => {
  let component: ExampleEditDialogComponent;
  let fixture: ComponentFixture<ExampleEditDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExampleEditDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExampleEditDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
