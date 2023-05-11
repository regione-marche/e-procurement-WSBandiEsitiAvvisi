package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.maggioli.eldasoft.BaseDBTest;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
@ContextConfiguration("file:src/test/resources/applicationContext.xml")
class TestBandiEsitiAvvisiManager extends BaseDBTest {

	@Autowired
	private BandiEsitiAvvisiManager bandiManager;
	@Autowired
	private DataSource dataSource;
	
	@BeforeAll
	void initTableContent() throws SQLException {
		System.out.println("TestBandiEsitiAvvisiManager");
	}

	@Test
	void test00_getElencoBandi() {
//		bandiManager.getElencoBandi("TIPO", "CONTRATTO", null, null, "CIG", "STAZIONE_APPALTANTE");
	}
	
	
	
}
