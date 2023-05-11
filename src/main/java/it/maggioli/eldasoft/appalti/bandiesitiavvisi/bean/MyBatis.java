package it.maggioli.eldasoft.appalti.bandiesitiavvisi.bean;

import org.apache.ibatis.session.LocalCacheScope;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Classe che crea il bean col la sessione per MyBatis
 * @author cmantini
 *
 */
@Configuration
public class MyBatis {

	@Autowired
	private org.apache.ibatis.session.Configuration mybatisConf;


	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
	    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	    
	    sqlSessionFactoryBean.setDataSource(dataSource);
	    sqlSessionFactoryBean.setTypeAliasesPackage("it.maggioli.eldasoft.appalti.bandiesitiavvisi.db.vo");
		sqlSessionFactoryBean.setConfiguration(mybatisConf);

		return sqlSessionFactoryBean;
	}

	@Bean
	public org.apache.ibatis.session.Configuration mybatisConf() {
		org.apache.ibatis.session.Configuration toReturn = new org.apache.ibatis.session.Configuration();

//		toReturn.setCallSettersOnNulls(true);
//		toReturn.setReturnInstanceForEmptyRow(true);
		toReturn.setLocalCacheScope(LocalCacheScope.STATEMENT);
		toReturn.setCacheEnabled(false);

		return toReturn;
	}
	
}
