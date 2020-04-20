package died.guia06;

import java.util.ArrayList;
import java.util.List;

public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	
	public int creditosObtenidos() {
		
		int creditosTotales = 0;
		
		for ( int iterador = 0 ; iterador < aprobados.size() ; iterador++ ) {
			
			creditosTotales+= (aprobados.get(iterador)).getCreditos();
			
		}
			
		return creditosTotales;
		
	}

	public void aprobar(Curso c) {
		
		this.cursando.remove(c); //se lo quita de la lista de cursando
		this.aprobados.add(c); //se lo agrega a la lista de aprobados
		
	}

	public void inscripcionAceptada(Curso c) {
		
		this.cursando.add(c);
		
	}
	
	// Override de método equals
	
	@Override
	
	public boolean equals(Object otroAlumno) {
		
		if(otroAlumno instanceof Alumno && (((Alumno)otroAlumno).nroLibreta == this.nroLibreta)) return true;
		else return false;
		
	}
	
	@Override
	
	public int compareTo(Alumno otroAlumno) {
		return (this.nombre.compareTo(otroAlumno.nombre));
	}
		
	
	// Otros métodos
	
	//constructor
//	Alumno(String nombre, Integer nroLibreta, List<Curso> cursando){
//	private List<Curso> cursando;
//	private List<Curso> aprobados;
//		
//		this.nombre.setNombre
//		nroLibreta;
//		cursando;
//		aprobados;
//		
//	}
	
	public ArrayList<Curso> cursandoDeAnioLectivoX (int x){
		
		ArrayList<Curso> enCurso = new ArrayList<>();
		
		
		for (int iterador = 0; iterador < this.cursando.size() ; iterador++ ) {
			
			if(((this.cursando.get(iterador)).getCicloLectivo()) == x) {
				
				enCurso.add((this.cursando.get(iterador)));
			}
		}
		
		return enCurso;
		
	}
	
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}
	
	
	
	
	

}
