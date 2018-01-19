import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitNewBookComponent } from './submit-new-book.component';

describe('SubmitNewBookComponent', () => {
  let component: SubmitNewBookComponent;
  let fixture: ComponentFixture<SubmitNewBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitNewBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitNewBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
