import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentSpotDialogComponent } from './rent-spot-dialog.component';

describe('RentSpotDialogComponent', () => {
  let component: RentSpotDialogComponent;
  let fixture: ComponentFixture<RentSpotDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentSpotDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentSpotDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
