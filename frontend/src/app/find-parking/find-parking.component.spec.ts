import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindParkingComponent } from './find-parking.component';

describe('FindParkingComponent', () => {
  let component: FindParkingComponent;
  let fixture: ComponentFixture<FindParkingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindParkingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindParkingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
