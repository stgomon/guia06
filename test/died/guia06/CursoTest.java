package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CursoTest {
	
	Curso curso1 = new Curso(1, "MAT1", 1, 3, 4, 6);
	Curso curso2 = new Curso(2, "MAT2", 1, 2, 2, 0);
	Curso curso3 = new Curso(3, "MAT3", 1, 1, 4, 6);
	Curso curso4 = new Curso(4, "MATA", 1, 1, 4, 6);
	Curso curso5 = new Curso(5, "MATB", 1, 1, 4, 6);
	Curso curso6 = new Curso(6, "MAT6", 2, 21, 4, 25);
	Curso curso7 = new Curso(7, "MAT7", 3, 20, 2, 46);
	Curso curso8 = new Curso(7, "MAT7", 3, 0, 2, 46);
	Alumno alumno1 = new Alumno("Alumno1", 3333);
	Alumno alumno2 = new Alumno("Alumno2", 1111);
	Alumno alumno3 = new Alumno("Alumno3", 3333);
	Alumno alumno4 = new Alumno("Alumno4", 4444);
	Alumno alumno5 = new Alumno("Alumno1", 4444);

	//Tests basados en incribir alumnos
	
	@Test
	void testInscribirAlumnoExistoso() {
		boolean resultado = curso2.inscribir(alumno1);
		assertTrue(resultado);
	}
	
	@Test
	void testNocuentaconloscreditosnecesario() {
		boolean resultado = curso1.inscribir(alumno1);
		assertFalse(resultado);
	}
	

	@Test
	void testEstainscriptoen3cursosdeaniolectivoX() {
		alumno1.inscripcionAceptada(curso1);
		alumno1.inscripcionAceptada(curso2);
		alumno1.inscripcionAceptada(curso3);
		boolean resultado = curso4.inscribir(alumno1);
		assertFalse(resultado);
		
	}
	
	@Test
	
	void testCupocompleto(){
		boolean resultado = curso8.inscribir(alumno1);
		assertFalse(resultado);
	}
	
	@Test
	void testImprimirporlibreta() {
		alumno2.aprobar(curso3);
		curso2.inscribir(alumno1);
		curso2.inscribir(alumno2);
		curso2.imprimirInscriptos("libreta");
	}
	
	@Test
	void testImprimirporCreditos() {
		alumno2.aprobar(curso3);
		curso2.inscribir(alumno1);
		curso2.inscribir(alumno2);
		curso2.imprimirInscriptos("creditos");
	}	
	
}
