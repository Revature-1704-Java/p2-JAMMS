import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookModificationComponent } from './book-modification.component';

describe('BookModificationComponent', () => {
  let component: BookModificationComponent;
  let fixture: ComponentFixture<BookModificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookModificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookModificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});