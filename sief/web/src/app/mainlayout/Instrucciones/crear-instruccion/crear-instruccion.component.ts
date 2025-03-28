import { Component, ViewChild, ElementRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ModalComponent } from '../modal/modal.component';

@Component({
    selector: 'app-crear-instruccion',
    standalone: true,
    templateUrl: './crear-instruccion.component.html',
    styleUrls: ['./crear-instruccion.component.css'],
    imports: [CommonModule, FormsModule, ModalComponent],
})
export class CrearInstruccionComponent {
    numeroFideicomiso: string = '';
    nombreFideicomiso: string = '';
    aliasFideicomiso: string = '';
    tipoInstruccion: string = '';
    comentario: string = '';

    mostrarModal: boolean = false;
    modalExitoso: boolean = false;
    codigo: string = '';

    mostrarModalCarga: boolean = false;
    selectedFile: File | null = null;
    fileName: string | null = null;
    fileSizeError: boolean = false;
    fileTypeError: boolean = false;

    @ViewChild('fileInput') fileInput!: ElementRef;

    cargarInstruccion() {
        this.mostrarModal = true;
        this.modalExitoso = false;
    }

    cerrarModal() {
        this.mostrarModal = false;
        this.modalExitoso = false;
    }

    validarCodigo() {
        if (this.codigo === '123456') {
            console.log('Instrucción cargada correctamente.');
            this.modalExitoso = true;
            this.mostrarModal = false;
        } else {
            alert('Código incorrecto. Inténtalo nuevamente.');
        }
    }

    enviarNuevoCodigo() {
        console.log('Nuevo código enviado al correo electrónico.');
        alert('Se ha enviado un nuevo código a tu correo.');
    }

    cancelar() {
        console.log('Instrucción cancelada');
    }

    abrirModalCarga() {
        this.mostrarModalCarga = true;
    }

    cerrarModalCarga(limpiarArchivo: boolean = false) {
        this.mostrarModalCarga = false;
        if (limpiarArchivo) {
            this.selectedFile = null;
            this.fileName = null;
            this.fileSizeError = false;
            this.fileTypeError = false;
        }
    }

    onFileSelected(event: any) {
        this.selectedFile = event.target.files[0];
        this.validateFile();
    }

    onDrop(event: DragEvent) {
        event.preventDefault();
        this.selectedFile = event.dataTransfer?.files[0] ?? null;
        this.validateFile();
    }

    onDragOver(event: DragEvent) {
        event.preventDefault();
    }

    validateFile() {
        this.fileSizeError = false;
        this.fileTypeError = false;

        if (this.selectedFile) {
            if (this.selectedFile.type !== 'application/pdf') {
                this.fileTypeError = true;
            } else if (this.selectedFile.size > 2 * 1024 * 1024) {
                this.fileSizeError = true;
            }
        }
    }

    cargarDocumento() {
        if (this.selectedFile && !this.fileSizeError && !this.fileTypeError) {
            console.log('Archivo seleccionado:', this.selectedFile);
            this.fileName = this.selectedFile.name;
            this.cerrarModalCarga();
        }
    }

    eliminarArchivo() {
        this.cerrarModalCarga(true);
    }
}