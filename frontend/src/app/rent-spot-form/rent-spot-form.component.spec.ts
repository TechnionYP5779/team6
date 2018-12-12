import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentSpotFormComponent } from './rent-spot-form.component';

describe('RentSpotFormComponent', () => {
  let component: RentSpotFormComponent;
  let fixture: ComponentFixture<RentSpotFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentSpotFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentSpotFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
