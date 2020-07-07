package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import died.guia06.*;

class AlumnoTest {

	Curso curso1 = new Curso(1, "MAT1", 1, 3, 4, 6);
	Curso curso2 = new Curso(2, "MAT2", 1, 2, 2, 0);
	Curso curso3 = new Curso(3, "MAT3", 1, 1, 4, 6);
	Curso curso6 = new Curso(6, "MAT6", 2, 21, 4, 25);
	Curso curso7 = new Curso(7, "MAT7", 3, 20, 2, 46);
	Alumno alumno1 = new Alumno("Alumno1", 3333);
	Alumno alumno2 = new Alumno("Alumno2", 1111);
	Alumno alumno3 = new Alumno("Alumno3", 3333);
	Alumno alumno4 = new Alumno("Alumno4", 4444);
	Alumno alumno5 = new Alumno("Alumno1", 4444);

	@Test
	void testCreditosObtenidos() {
		//El alumno1 tiene aprobado el curso 1. Se procede a verificar la cantidad de créditos que posee en total.
		
		//Esto es porque no me funcionó el @BeforeClass
		alumno1.aprobar(curso1);
		//
		Integer creditosDeAlumno1 = alumno1.creditosObtenidos(); 
		assertEquals(4,creditosDeAlumno1);
		
	}

	@Test
	void testAprobar() {
		
		//El alumno1 aprueba el curso2
		
		//
		alumno1.inscripcionAceptada(curso2);
		//
		alumno1.aprobar(curso2);
		
	}

	@Test
	void testInscripcionAceptada() {
		
		alumno1.inscripcionAceptada(curso7);
		
	}
	
	@Test
	void testEqualsValido(){

		assertTrue(alumno1.equals(alumno3));
		
	}
	
	@Test
	void testEqualsNoValido(){

		assertFalse(alumno4.equals(alumno3));
		
	}
	
	@Test
	void testEqualsNoValidoBranchExterior() {
		assertFalse(alumno4.equals(curso1));
	}
	
	@Test
	void testCompareToDa0() {
		int valor = (alumno1.compareTo(alumno5));
		assertEquals(0,valor);
	}
	
	@Test
	void testCompareToDaMenorA1() {
		int valor = (alumno1.compareTo(alumno2));
		assertEquals(-1,valor);
	}

	@Test
	void testCursandoDeAniLectivo1() {
		alumno1.inscripcionAceptada(curso1);
		alumno1.inscripcionAceptada(curso2);
		alumno1.inscripcionAceptada(curso7);
		ArrayList<Curso> materias = new ArrayList<Curso>();
		ArrayList<Curso> materiasAnioLectivo1 = new ArrayList<Curso>();
		materias = alumno1.cursandoDeAnioLectivoX(1);
		materiasAnioLectivo1.add(curso1);
		materiasAnioLectivo1.add(curso2);
		assertEquals(materiasAnioLectivo1,materias);
	}
	
}
