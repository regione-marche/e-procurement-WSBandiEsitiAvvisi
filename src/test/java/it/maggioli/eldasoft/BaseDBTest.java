package it.maggioli.eldasoft;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDBTest {

	@Autowired
	private DataSource dataSource;
	
	@BeforeAll
	protected void initDB() throws SQLException {	//Non potendolo fare static, questo metodo viene chiamato ad ogni @Test
		if (!new File("src/test/resources/database.mv.db").exists()) {
			System.out.println("START - INIT");
		
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.execute("CREATE TABLE W_QUARTZLOCK ( "
						+ "codapp VARCHAR(10) NOT NULL, "
						+ "job VARCHAR(200) NOT NULL, "
						+ "lock_date DATETIME NOT NULL, "
						+ "server_name VARCHAR(100), "
						+ "node_name VARCHAR(100), "
						+ "  constraint PK_W_QUARTZLOCK primary key (CODAPP, JOB))");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			System.out.println("END - INIT");
		}
	}
	
}
