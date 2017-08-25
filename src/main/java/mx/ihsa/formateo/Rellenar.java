package mx.ihsa.formateo;

/**
 * Ejemplo para rellenar (padding) una cadena a un número fijo de posiciones.
 * @author mrojas
 *
 */
public class Rellenar {

	/**
	 * Se itera tantas veces como se indica en la longitud para poder llenar la cadena.
	 * @param val El valor numérico a representar en la cadena.
	 * @param longitud El número fijo de posiciones que debe contener la cadena.
	 * @return La cadena con la representación del valor.
	 */
	public static String rellenar(int val, int longitud) {
		String retVal = "";
		String strVal = String.valueOf(val);

		if(strVal.length() < longitud) {
			for(int i = strVal.length(); i < longitud; i++) {
				retVal += "0";
			}

			retVal += strVal;
		} else {
			retVal = strVal;
		}

		return retVal;
	}

	/**
	 * Se rellena la cadena con el caracter 0 para lograr la longitud indicada.
	 * @param val El valor numérico a representar en la cadena.
	 * @param longitud El número fijo de posiciones que debe contener la cadena.
	 * @return La cadena con la representación del valor.
	 */
	public static String pad(int val, int longitud) {
		String retVal = null;
		String strVal = String.valueOf(val);

		if(strVal.length() < longitud) {
			//Ver https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
			//Ver https://examples.javacodegeeks.com/core-java/lang/string/java-string-format-example/
			retVal = String.format("%0" + longitud + "d", val);
		} else {
			retVal = strVal;
		}

		return retVal;
	}

	
	
	public static void main(String[] args) {
		System.out.println(rellenar(425, 10));
		System.out.println(pad(425, 10));
	}

}