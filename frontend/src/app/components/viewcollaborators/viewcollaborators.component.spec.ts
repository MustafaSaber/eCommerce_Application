import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewcollaboratorsComponent } from './viewcollaborators.component';

describe('ViewcollaboratorsComponent', () => {
  let component: ViewcollaboratorsComponent;
  let fixture: ComponentFixture<ViewcollaboratorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewcollaboratorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewcollaboratorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
