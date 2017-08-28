package mx.ihsa.fluent;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcularProduccion {

	private final static Logger LOGGER = LoggerFactory.getLogger(CalcularProduccion.class);
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<Presion> presiones = new ArrayList<>();
		List<Produccion> producciones = new ArrayList<>();
		
		int exitStatus = 0;
		
		try {
			final Timestamp fechaCalculo = new Timestamp(sdf.parse("2017-01-01 23:59").getTime());
			
			LOGGER.info("Generando presiones ....");
			
			Presion presion = 
					new Presion()
					.withEstrangulador(10)
					.withPozo(100)
					.withPresionCabeza(new BigDecimal("350"))
					.withPresionLinea(new BigDecimal("100"))
					.withFecha(new Timestamp(sdf.parse("2017-01-01 14:55").getTime()));
			
			presiones.add(presion);
			
			presion = 
					new Presion()
					.withEstrangulador(10)
					.withPozo(101)
					.withPresionCabeza(new BigDecimal("300"))
					.withPresionLinea(new BigDecimal("150"))
					.withFecha(new Timestamp(sdf.parse("2017-01-01 14:42").getTime()));
			
			presiones.add(presion);
			
			presion = 
					new Presion()
					.withEstrangulador(34)
					.withPozo(102)
					.withPresionCabeza(new BigDecimal("300"))
					.withPresionLinea(new BigDecimal("200"))
					.withFecha(new Timestamp(sdf.parse("2017-01-01 14:55").getTime()));
			
			presiones.add(presion);
			
//			presion = 
//					new Presion()
//					.withFecha(new Timestamp(sdf.parse("2017-01-01 14:55").getTime()));
//			
//			presiones.add(presion);
			
			
			LOGGER.info("Calculando producciones para {} ...", fechaCalculo);
			
			presiones.forEach((elemento) -> {
				Formula formula = null;
				
				elemento.validar();
				
				if(elemento.getPresionCabeza().compareTo(elemento.getPresionLinea()) > 0) {
					formula = new Burgos();
				} else {
					formula = new Gilbert();
				}
				
				Produccion prod = 
						new Produccion()
						.withPozo(elemento.getPozoId())
						.withFecha(fechaCalculo)
						.withPresion(elemento)
						.withFormula(formula)
						.calcular();
				
				producciones.add(prod);
			});
			
			LOGGER.info("Las producciones han sido calculadas ...");
			
			producciones.forEach((produccion) -> {
				LOGGER.info("Producción: {}", produccion);
			});
			
		} catch (ParseException e) {
			LOGGER.error("", e);
			exitStatus = 1;
		}

		LOGGER.info("Fin del proceso.");
		
		System.exit(exitStatus);
	}

}
