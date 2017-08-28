package mx.ihsa.fluent;

import java.math.BigDecimal;

public interface Formula {

	public BigDecimal calcular(Presion presion) throws CalculoException;
	
}
