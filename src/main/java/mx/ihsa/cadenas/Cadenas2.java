package mx.ihsa.cadenas;

/**
 * Para el ejercicio de mostrar el efecto de concatenar literales de texto en el bytcode generado.
 * Utilizar javap -c -s -verbose Cadenas2
 * @author mrojas
 *
 */
public class Cadenas2 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		sb.append("abc");
		sb.append("def");
		sb.append("ghi");

		System.out.println(sb);
	}
}
