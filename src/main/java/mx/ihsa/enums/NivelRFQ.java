package mx.ihsa.enums;

/**
 * Posibles niveles de una RFQ
 * @author mrojas
 *
 */
public enum NivelRFQ {

	BAJO(100),
	MEDIO(200),
	ALTO(500),
	URGENTE(1000);
	
	private final int nivel;
	
	private NivelRFQ(int nivel) {
		this.nivel = nivel;
	}
	
	public int getNivel() {
		return nivel;
	}
}
