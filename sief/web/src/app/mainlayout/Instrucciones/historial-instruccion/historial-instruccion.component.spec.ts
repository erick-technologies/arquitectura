import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialInstruccionComponent } from './historial-instruccion.component';

describe('HistorialInstruccionComponent', () => {
  let component: HistorialInstruccionComponent;
  let fixture: ComponentFixture<HistorialInstruccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HistorialInstruccionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistorialInstruccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
