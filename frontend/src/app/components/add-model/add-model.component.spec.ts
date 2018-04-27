import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddModelComponent } from './add-model.component';

describe('AddModelComponent', () => {
  let component: AddModelComponent;
  let fixture: ComponentFixture<AddModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddModelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
