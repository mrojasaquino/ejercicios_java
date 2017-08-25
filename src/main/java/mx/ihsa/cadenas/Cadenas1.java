package mx.ihsa.cadenas;

/**
 * Para el ejercicio de mostrar el efecto de concatenar literales de texto en el bytcode generado.
 * Utilizar javap -c -s -verbose Cadenas1
 * @author mrojas
 *
 */
public class Cadenas1 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = "ghi";

		System.out.println(s1 + s2 + s3);
	}
}
