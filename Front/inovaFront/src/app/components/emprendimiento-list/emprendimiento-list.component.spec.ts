import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmprendimientoListComponent } from './emprendimiento-list.component';

describe('EmprendimientoListComponent', () => {
  let component: EmprendimientoListComponent;
  let fixture: ComponentFixture<EmprendimientoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmprendimientoListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmprendimientoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
