import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BecomeHostComponent } from './become-host.component';

describe('BecomeHostComponent', () => {
  let component: BecomeHostComponent;
  let fixture: ComponentFixture<BecomeHostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BecomeHostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BecomeHostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
