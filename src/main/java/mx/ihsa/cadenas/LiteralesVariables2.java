package mx.ihsa.cadenas;
public class LiteralesVariables2 {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		StringBuilder r = new StringBuilder();
		r.append("La suma de ").append(a).append(" mas ").append(b).append(" es : ").append(a + b);

		System.out.println(r);
	}
}
