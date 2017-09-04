package mx.ihsa.consultas;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ejemplo de consulta con valores insertados directamente en la consulta.
 * @author mrojas
 *
 */
public class InLine {

	private static final Logger LOGGER = LoggerFactory.getLogger(InLine.class);
	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://192.168.254.59/chinook";
		String user = "ihsa";
		String password = "ihsa";
		
		try(
				Connection conn = DriverManager.getConnection(url, user, password); 
				DSLContext ctx = DSL.using(conn, SQLDialect.POSTGRES_9_5);) {
			String sql1 = "SELECT * FROM customer WHERE country = 'Germany'";
			String sql2 = "SELECT * FROM customer WHERE country = 'Belgium'";
			String sql3 = 
					"SELECT i.invoiceid, il.* \n" +
					"FROM invoiceline il \n" +
					"	INNER JOIN invoice i ON il.invoiceid = i.invoiceid \n" +
					"WHERE i.invoiceid = 45";
			
			
			Result<Record> rs1 = ctx.fetch(sql1);
			Result<Record> rs2 = ctx.fetch(sql2);
			Result<Record> rs3 = ctx.fetch(sql3);
			
			rs1.forEach((record) -> {
				LOGGER.info("Germany {}", record);
			});
			
			rs2.forEach((record) -> {
				LOGGER.info("Belgium {}", record);
			});
			
			rs3.forEach((record) -> {
				LOGGER.info("Invoice {}", record);
			});
			
			ctx.close();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
}
