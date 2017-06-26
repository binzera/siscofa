package br.gms.siscofa.infra.spring;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
@PropertySource("classpath:db.properties")
public class PersistenceConfig {

	@Autowired
	private Environment environment;

	private Logger logger = Logger.getLogger(getClass());

	@Bean
	public DataSource dataSource() {
//		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		 dataSource.setDriverClassName(environment.getProperty("db.driver"));
//		 dataSource.setUrl(environment.getProperty("db.url"));
//		 dataSource.setUsername(environment.getProperty("db.username"));
//		 dataSource.setPassword(environment.getProperty("db.password"));

		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		try {
			dataSource = (DataSource) jndi
					.lookup("java:jboss/datasources/SiscofaMysql");
		} catch (NamingException e) {
			logger.error("NamingException for java:jboss/datasources/SiscofaMysql", e);
		}
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory
				.setPackagesToScan(new String[] { "br.gms.siscofa.model" });

		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect",
				environment.getProperty("hibernate.dialect"));

		sessionFactory.setHibernateProperties(properties);

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
		return transactionManager;
	}

}
