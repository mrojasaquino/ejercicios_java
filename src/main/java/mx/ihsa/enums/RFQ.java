package mx.ihsa.enums;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de Request for Quotation.
 * @author mrojas
 *
 */
@Getter
@Setter
public class RFQ {

	private int rfqId;
	private String descripcion;
	private EstatusRFQ estado;
	private AccionRFQ accion;
	private int nivel;
	private Timestamp creado;
	private Timestamp modificado;
	
}
