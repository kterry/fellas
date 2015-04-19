package fellas;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Data persistence configuration.
 * http://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-
 * tutorial-part-one-configuration/
 */
@Configuration
@EnableJpaRepositories("fellas.model")
@EnableTransactionManagement
public class PersistenceContext {

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Value("classpath:hibernate.properties")
    private Properties hibernateProperties;

    // DataSource Bean
    @Bean(destroyMethod = "close")
    DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(dbDriver);
        dataSourceConfig.setJdbcUrl(dbUrl);
        dataSourceConfig.setUsername(dbUsername);
        dataSourceConfig.setPassword(dbPassword);

        return new HikariDataSource(dataSourceConfig);
    }

    // Create a new LocalContainerEntityManagerFactoryBean.
    // We need to create this object because it creates the JPA
    // EntityManagerFactory.
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("fellas.model");
        entityManagerFactoryBean.setJpaProperties(hibernateProperties);

        return entityManagerFactoryBean;
    }

    // Because we are using JPA, we have to create a transaction manager bean
    // that integrates the JPA provider with the Spring transaction mechanism.
    // We can do this by using the JpaTransactionManager class as the
    // transaction manager of our application
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
