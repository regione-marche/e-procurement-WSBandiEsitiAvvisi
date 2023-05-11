package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

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
class TestQuartzLockManager extends BaseDBTest {

	@Autowired
	private QuartzLockManager manager;
	@Autowired
	private DataSource dataSource;
	
	@Test
	void test00_insert() throws SQLException, ClassNotFoundException {
		System.out.println("START - INSERT");
		manager.insertQuartzLock("COD_APP", "JOB_CLASS", "JOB_METHOD", "SERVER", "NODE");
		Connection connection = dataSource.getConnection();
		Statement prepareStatement = connection.createStatement();
		ResultSet rs = prepareStatement.executeQuery("SELECT COUNT(*) FROM w_quartzlock WHERE CODAPP = 'COD_APP' AND JOB = 'JOB_CLASS.JOB_METHOD'");
	    rs.next();
	    int count = rs.getInt(1);
	    System.out.println(count);
	    assertEquals(1, count);
		System.out.println("END - INSERT");
	}
	@Test
	void test01_deleteNotExistingQuartz() throws SQLException, ClassNotFoundException {
		System.out.println("START - NOT EXISTING DELETE");

		manager.deleteQuartzLock("RANDOM", "RANDOM", "RANDOM");
		Connection connection = dataSource.getConnection();
		Statement prepareStatement = connection.createStatement();
		ResultSet rs = prepareStatement.executeQuery("SELECT COUNT(*) FROM w_quartzlock WHERE CODAPP = 'COD_APP' AND JOB = 'JOB_CLASS.JOB_METHOD'");
	    rs.next();
	    int count = rs.getInt(1);
	    System.out.println(count);
	    assertEquals(1, count);
		System.out.println("END - NOT EXISTING DELETE");
	}
	
	@Test
	void test02_deleteExistingQuartz() throws SQLException, ClassNotFoundException {
		System.out.println("START - DELETE");

		manager.deleteQuartzLock("COD_APP", "JOB_CLASS", "JOB_METHOD");
		Connection connection = dataSource.getConnection();
		Statement prepareStatement = connection.createStatement();
		ResultSet rs = prepareStatement.executeQuery("SELECT COUNT(*) FROM w_quartzlock WHERE CODAPP = 'COD_APP' AND JOB = 'JOB_CLASS.JOB_METHOD'");
	    rs.next();
	    int count = rs.getInt(1);
	    System.out.println(count);
	    assertEquals(0, count);
		System.out.println("END - DELETE");
	}
	
	
}
