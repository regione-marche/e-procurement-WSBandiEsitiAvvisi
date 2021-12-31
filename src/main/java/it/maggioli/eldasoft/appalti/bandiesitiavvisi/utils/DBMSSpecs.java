/*
 * Created on 15/mag/18
 *
 * Copyright (c) Maggioli S.p.A. - Divisione ELDASOFT
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di Maggioli S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di
 * aver prima formalizzato un accordo specifico con Maggioli.
 */
package it.maggioli.eldasoft.appalti.bandiesitiavvisi.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.util.StringUtils;

/**
 * Classe contenente le specifiche del DBMS in uso.
 * 
 * @author Stefano.Sabbadin
 */
public class DBMSSpecs {

	/** Costante che individua la tipologia di database Oracle. */
	public static final String DATABASE_ORACLE = "ORA";

	/** Costante che individua la tipologia di database Microsoft SQL Server. */
	public static final String DATABASE_SQL_SERVER = "MSQ";

	/** Costante che individua la tipologia di database PostgreSQL. */
	public static final String DATABASE_POSTGRES = "POS";

	/** Costante che individua la tipologia di database IBM DB2. */
	public static final String DATABASE_DB2 = "DB2";

	/**
	 * Datasource di connessione al DB.
	 */
	private DataSource dataSource;

	/** Nome commerciale del DBMS utilizzato. */
	private String productName;

	/** Versione del DBMS utilizzato. */
	private String productVersion;

	/** Codifica interna del DBMS. */
	private String internalDbmsCode;

	/**
	 * Imposta il datasource e determina il tipo di DBMS utilizzato.
	 * 
	 * @param dataSource
	 *            datasource di collegamento al db
	 * 
	 * @throws SQLException
	 */
	public void setDataSource(DataSource dataSource) throws SQLException {
		Connection c = null;
		try {
			c = dataSource.getConnection();
			this.productName = c.getMetaData().getDatabaseProductName();
			this.productVersion = c.getMetaData().getDatabaseProductVersion();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
		if ("Oracle".equalsIgnoreCase(productName)) {
			this.internalDbmsCode = DBMSSpecs.DATABASE_ORACLE;
		} else if ("Microsoft SQL Server".equalsIgnoreCase(productName)) {
			this.internalDbmsCode = DBMSSpecs.DATABASE_SQL_SERVER;
		} else if ("PostgreSQL".equalsIgnoreCase(productName)) {
			this.internalDbmsCode = DBMSSpecs.DATABASE_POSTGRES;
		} else if (StringUtils.startsWithIgnoreCase(productName, "DB2/")) {
			this.internalDbmsCode = DBMSSpecs.DATABASE_DB2;
		}
	}

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @return Ritorna productName.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return Ritorna productVersion.
	 */
	public String getProductVersion() {
		return productVersion;
	}

	/**
	 * @return Ritorna internalDbmsCode.
	 */
	public String getInternalDbmsCode() {
		return internalDbmsCode;
	}

}