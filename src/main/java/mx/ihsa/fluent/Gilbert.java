package mx.ihsa.fluent;

import java.math.BigDecimal;

public class Gilbert implements Formula {

	@Override
	public BigDecimal calcular(Presion presion) throws CalculoException {
		BigDecimal retVal = BigDecimal.ZERO;

		try {
			retVal = 
					presion.getPresionCabeza()
					.multiply(presion.getPresionLinea());
		} catch (Exception e) {
			throw new CalculoException(e);
		}

		return retVal;
	}


	@Override
	public String toString() {
		return "Fórmula Gilbert";
	}
}
