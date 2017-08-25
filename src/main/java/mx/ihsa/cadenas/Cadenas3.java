package mx.ihsa.cadenas;

/**
 * Para el ejercicio de mostrar el efecto de concatenar literales de texto en el bytcode generado.
 * Utilizar javap -c -s -verbose Cadenas3
 * @author mrojas
 *
 */
public class Cadenas3 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		sb.append("abc")
		.append("def")
		.append("ghi");

		System.out.println(sb);
	}
}
