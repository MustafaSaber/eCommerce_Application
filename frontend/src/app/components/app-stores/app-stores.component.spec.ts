import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppStoresComponent } from './app-stores.component';

describe('AppStoresComponent', () => {
  let component: AppStoresComponent;
  let fixture: ComponentFixture<AppStoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppStoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppStoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
