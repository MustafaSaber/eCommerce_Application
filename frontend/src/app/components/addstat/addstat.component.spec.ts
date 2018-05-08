import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddstatComponent } from './addstat.component';

describe('AddstatComponent', () => {
  let component: AddstatComponent;
  let fixture: ComponentFixture<AddstatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddstatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddstatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
