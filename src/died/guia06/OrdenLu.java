package died.guia06;

import java.util.Comparator;

public class OrdenLu implements Comparator<Alumno> {
	
	public OrdenLu(){
		
	}
	
	@Override
	public int compare(Alumno alumno1 , Alumno alumno2) {
		
	return alumno1.getNroLibreta().compareTo(alumno2.getNroLibreta()); 
	
	}
	
}
