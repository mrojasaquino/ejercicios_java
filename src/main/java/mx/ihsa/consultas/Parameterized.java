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
 * Ejemplo de consultas usando parámetros.
 * @author mrojas
 *
 */
public class Parameterized {

	private static final Logger LOGGER = LoggerFactory.getLogger(InLine.class);

	public static void main(String[] args) {
		String url = "jdbc:postgresql://192.168.254.59/chinook";
		String user = "ihsa";
		String password = "ihsa";
		String[] countries = {"Belgium", "Germany"};

		try(
				Connection conn = DriverManager.getConnection(url, user, password); 
				DSLContext ctx = DSL.using(conn, SQLDialect.POSTGRES_9_5);) {
			String sql1 = "SELECT * FROM customer WHERE country = ?";
			
			String sql2 = 
					"SELECT i.invoiceid, il.* \n" +
							"FROM invoiceline il \n" +
							"	INNER JOIN invoice i ON il.invoiceid = i.invoiceid \n" +
							"WHERE i.invoiceid = ?";


			Result<Record> rs = null;
			
			for(String country : countries) {
				rs = ctx.fetch(sql1, country);
				
				rs.forEach((record) -> {
					LOGGER.info("{} {}", country, record);
				});
			}
			
			rs = ctx.fetch(sql2, 45);
			
			rs.forEach((record) -> {
				LOGGER.info("Invoice {}", record);
			});
			
			
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

}
