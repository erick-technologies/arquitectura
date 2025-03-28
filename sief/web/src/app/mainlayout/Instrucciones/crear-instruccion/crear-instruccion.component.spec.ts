import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearInstruccionComponent } from './crear-instruccion.component';

describe('CrearInstruccionComponent', () => {
  let component: CrearInstruccionComponent;
  let fixture: ComponentFixture<CrearInstruccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearInstruccionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrearInstruccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
