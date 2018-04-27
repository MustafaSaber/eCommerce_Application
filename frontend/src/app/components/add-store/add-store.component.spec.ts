import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStoreComponent } from './add-store.component';

describe('AddStoreComponent', () => {
  let component: AddStoreComponent;
  let fixture: ComponentFixture<AddStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
