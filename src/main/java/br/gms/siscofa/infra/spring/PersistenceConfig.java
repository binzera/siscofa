package br.gms.siscofa.infra.spring;

//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:hibernate.properties")
public class PersistenceConfig {

//	@Autowired
//	private Environment environment;
//
//	@Bean
//	@Profile("dev")
//	public DataSource dataSource() {
//		
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUsername("root");
//		dataSource.setPassword("soh");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/siscofa-simp");
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		
//		return dataSource;
//		
////		DataSource dataSource = null;
////		JndiTemplate jndi = new JndiTemplate();
////		try {
////			dataSource = (DataSource) jndi
////					.lookup("java:jboss/datasources/SiscofaMysql");
////		} catch (NamingException e) {
////			System.out.println("NamingException for java:jboss/datasources/SiscofaMysql" + e);
////		}
////		return dataSource;
//	}
//
//	@Bean
//	public LocalSessionFactoryBean sessionFactory(DataSource dataSource, Properties additionalProperties) {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		sessionFactory
//				.setPackagesToScan(new String[] { "br.gms.siscofa.model" });
//
//		sessionFactory.setHibernateProperties(additionalProperties);
//
//		return sessionFactory;
//	}
//	
//	@Bean
//	@Profile("dev")
//	public Properties additionalProperties() {
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.show_sql", "true");
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		return properties;
//	}
//
//	@Bean
//	@Autowired
//	public HibernateTransactionManager transactionManager(
//			SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
//				sessionFactory);
//		return transactionManager;
//	}

}
