package mx.ihsa.fluent;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produccion {

	private final static Logger LOGGER = LoggerFactory.getLogger(Produccion.class);

	private int pozoId;
	private Timestamp fecha;
	private Presion presion;
	private Formula formula;
	private BigDecimal volumen;

	public Produccion withPozo(int pozoId) {
		this.pozoId = pozoId ;
		return this;
	}

	public Produccion withFecha(Timestamp fecha) {
		this.fecha = fecha;
		return this;
	}

	public Produccion withPresion(Presion presion) {
		this.presion = presion;
		return this;
	}

	public Produccion withFormula(Formula formula) {
		this.formula = formula;
		return this;
	}


	public Produccion calcular() {
		LOGGER.info("Calculando con presion {} usando la fórmula {} ...", presion, formula);
		try {
			presion.validar();
			setVolumen(formula.calcular(presion));
		} catch (CalculoException e) {
			LOGGER.error("", e);
		}

		return this;
	}

	@Override
	public String toString() {
		return "Produccion [pozoId=" + pozoId + ", fecha=" + fecha + ", presion=" + presion + ", formula=" + formula
				+ ", volumen=" + volumen + "]";
	}
}
