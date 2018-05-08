import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProdDetalisComponent } from './view-prod-detalis.component';

describe('ViewProdDetalisComponent', () => {
  let component: ViewProdDetalisComponent;
  let fixture: ComponentFixture<ViewProdDetalisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewProdDetalisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProdDetalisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
