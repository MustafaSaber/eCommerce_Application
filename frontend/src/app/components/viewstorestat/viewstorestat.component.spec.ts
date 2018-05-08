import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewstorestatComponent } from './viewstorestat.component';

describe('ViewstorestatComponent', () => {
  let component: ViewstorestatComponent;
  let fixture: ComponentFixture<ViewstorestatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewstorestatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewstorestatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
