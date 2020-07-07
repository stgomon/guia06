package died.guia06;
import java.util.Comparator;

public class OrdenCreditos implements Comparator<Alumno> {
	
	@Override
	public int compare(Alumno alumno1 , Alumno alumno2) {
		Integer casting1 = (Integer) (alumno1.creditosObtenidos());
		Integer casting2 = (Integer) (alumno2.creditosObtenidos());
	return casting1.compareTo(casting2); //porque el compareTo no se puede usar para datos primitivos
}

}
