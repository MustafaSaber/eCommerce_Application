import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddstorestatComponent } from './addstorestat.component';

describe('AddstorestatComponent', () => {
  let component: AddstorestatComponent;
  let fixture: ComponentFixture<AddstorestatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddstorestatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddstorestatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
