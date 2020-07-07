package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer unId, String unNombre, Integer unCicloLectivo, Integer unCupo, Integer nroCreditos, Integer nroCreditosRequeridos) {
		
		this.id = unId;
		this.nombre = unNombre;
		this.cicloLectivo = unCicloLectivo;
		this.cupo = unCupo;
		this.creditos = nroCreditos;
		this.creditosRequeridos = nroCreditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}

	/**
	 * Este mÃ©todo, verifica si el alumno se puede inscribir y si es asÃ­ lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que estÃ¡ inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno estÃ¡ inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultÃ¡neo a no mÃ¡s de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	
	public Boolean inscribir(Alumno a) {
		if ((a.creditosObtenidos() >= this.creditosRequeridos) && (this.cupo != 0) && (((a.cursandoDeAnioLectivoX(this.cicloLectivo)).size()) < 3)) {			
			this.inscriptos.add(a);
			a.inscripcionAceptada(this);
			this.cupo = (this.cupo) - 1;
			
		//	INICIO -- PARTE DE AGREGARSE AL LOG
		try {
		log.registrar(this, "inscribir ",a.toString());
		}
		catch (IOException excepcionEnRegistrar){
			System.out.println("Ocurrió una excepción de E/S");
		}
		//  FIN -- PARTE DE AGREGARSE AL LOG
		
		return true;
		}
		else {
		return false;
	}
	}
	
	
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos(String palabra) {
		
		//si se ingresa el String creditos o libreta, imprimirá la lista de incriptos al curso ordenados segun se eligió
		
		try {
			if (palabra.equals("creditos")) {
				Collections.sort(this.inscriptos, new OrdenCreditos());
				System.out.println("Inscriptos ordenados por creditos obtenidos: ");
				for (int i = 0 ; i < this.inscriptos.size() ; i++) {
					System.out.println((this.inscriptos.get(i)).creditosObtenidos());
				}
				log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");		//LOG
				return;
			}
			if (palabra.equals("libreta")) {
				Collections.sort(this.inscriptos, new OrdenLu());
				System.out.println("Inscriptos ordenados por libreta universitaria: ");
				for (int i = 0 ; i < this.inscriptos.size() ; i++) {
					System.out.println((this.inscriptos.get(i)).getNroLibreta());
				}
				log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");		//LOG
				return;
			}
			
			System.out.println("No ha seleccionado una opción válida");
			return ;
		}
			
	
			catch (IOException excepcionEnRegistrar) {
			System.out.println("Ocurrió una excepción de E/S");
		}
	}
	
	
	
	

//getters and setters
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCicloLectivo() {
		return cicloLectivo;
	}


	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public Integer getCupo() {
		return cupo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public List<Alumno> getInscriptos() {
		return inscriptos;
	}


	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}


	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}


	public Registro getLog() {
		return log;
	}


	public void setLog(Registro log) {
		this.log = log;
	}
}
