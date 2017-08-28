package mx.ihsa.fluent;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Presion {

	private int pozoId;
	private int estranguladorId;
	private Timestamp fecha;
	private BigDecimal presionCabeza;
	private BigDecimal presionLinea;
	
	public Presion withPozo(int pozoId) {
		this.pozoId = pozoId;
		return this;
	}
	
	public Presion withEstrangulador(int estranguladorId) {
		this.estranguladorId = estranguladorId;
		return this;
	}
	
	public Presion withFecha(Timestamp fecha) {
		this.fecha = fecha;
		return this;
	}
	
	public Presion withPresionCabeza(BigDecimal presionCabeza) {
		this.presionCabeza = presionCabeza;
		return this;
	}
	
	public Presion withPresionLinea(BigDecimal presionLinea) {
		this.presionLinea = presionLinea ;
		return this;
	}
	
	public Presion validar() {
		checkArgument(fecha != null, "La presion no tiene asignada una fecha.");
		checkArgument(presionCabeza != null, "No se ha establecido la presión de cabeza.");
		checkArgument(presionLinea != null, "No se ha establecido la presión de línea.");
		checkArgument(estranguladorId > 0, "No se ha establecido el estrangulador.");
		
		return this;
	}

	@Override
	public String toString() {
		return "Presion [pozoId=" + pozoId + ", estranguladorId=" + estranguladorId + ", fecha=" + fecha
				+ ", presionCabeza=" + presionCabeza + ", presionLinea=" + presionLinea + "]";
	}
	
	
}
