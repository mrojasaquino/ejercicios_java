package mx.ihsa.enums;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Ejemplo de uso de enums.
 * @author mrojas
 *
 */
public class ProcesarRfq {

	public static void main(String[] args) {

		ProcesarRfq prfq = new ProcesarRfq();
		
		RFQ rfq = new RFQ();
		rfq.setRfqId(1);
		rfq.setNivel(NivelRFQ.MEDIO.getNivel());
		rfq.setEstado(EstatusRFQ.BORRADOR);
		rfq.setAccion(AccionRFQ.PUBLICAR);
		rfq.setCreado(Timestamp.valueOf(LocalDateTime.now()));
		
		System.out.println("Estado de la RFQ : " + rfq.getEstado().name());
		
		prfq.procesar(rfq);
		
		System.out.println("Estado de la RFQ : " + rfq.getEstado().name());

		for(EstatusRFQ estatus : EstatusRFQ.values()) {
			System.out.println("Posibles estatus : " + estatus);
		}
		
		for(NivelRFQ nivel : NivelRFQ.values()) {
			System.out.println("Nivel : " + nivel.name() + " - " + nivel.getNivel());
		}
	}

	
	public void procesar(RFQ rfq) {
		
		switch(rfq.getAccion()) {
		case ADJUDICAR:
			rfq.setEstado(EstatusRFQ.ADJUDICADA);
			rfq.setAccion(AccionRFQ.CERRAR);
			break;
		case CANCELAR:
			rfq.setEstado(EstatusRFQ.CANCELADA);
			rfq.setAccion(AccionRFQ.NINGUNA);
			break;
		case CERRAR:
			rfq.setEstado(EstatusRFQ.CERRADA);
			rfq.setAccion(AccionRFQ.NINGUNA);
			break;
		case PUBLICAR:
			rfq.setEstado(EstatusRFQ.PUBLICADA);
			rfq.setAccion(AccionRFQ.ADJUDICAR);
			break;
		default:
			break;
		
		}

		rfq.setModificado(Timestamp.valueOf(LocalDateTime.now()));
		
	}
}
