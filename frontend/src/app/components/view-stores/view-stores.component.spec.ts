import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStoresComponent } from './view-stores.component';

describe('ViewStoresComponent', () => {
  let component: ViewStoresComponent;
  let fixture: ComponentFixture<ViewStoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewStoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewStoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
