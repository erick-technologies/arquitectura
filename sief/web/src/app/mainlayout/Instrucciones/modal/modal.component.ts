import { CommonModule } from '@angular/common';
import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
  standalone: true,
  imports: [CommonModule],
})
export class ModalComponent {
  @Input() mostrarModal: boolean = false;
  @Input() titulo: string = '';
  @Input() botones: { texto: string; accion: () => void }[] = [];
  @Input() mostrarFooter: boolean = true;

  @Output() cerrar = new EventEmitter<void>();

  cerrarModal() {
    this.mostrarModal = false;
    this.cerrar.emit();
  }
}