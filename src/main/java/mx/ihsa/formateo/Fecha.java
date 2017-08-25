package mx.ihsa.formateo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * Ejemplos de formateo de fechas. Revisar el enfoque utilizado en ambos métodos
 * y el problema que se presenta en el resultado.
 * @author mrojas
 *
 */
public class Fecha {
	
	public static void main(String[] args) {
		String fecha = "15/02/2017";
		try {
			System.out.println(formatear(fecha));
			System.out.println(formatear2(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	
	public static Date formatear(String fecha) throws ParseException {
		Date retVal = null;
		// Revisar https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		retVal = sdf.parse(fecha);
		
		return retVal;
	}
	
	public static Date formatear2(String fecha) {
		int dia = Integer.parseInt(fecha.substring(0,2));
		int mes = Integer.parseInt(fecha.substring(3,5));
		int anio = Integer.parseInt(fecha.substring(6));
		
		DateTime dt = new DateTime(anio, mes, dia, 0, 0, 0);
		
		return dt.toDate();
	}
}
