import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExampleAddDialogComponent } from './example-add-dialog.component';

describe('ExampleAddDialogComponent', () => {
  let component: ExampleAddDialogComponent;
  let fixture: ComponentFixture<ExampleAddDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExampleAddDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExampleAddDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
