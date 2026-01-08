package mate.academy.javabookstore.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

@Configuration
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        sessionFactory.setPackagesToScan("mate.academy.javabookstore");

        Properties properties = new Properties();
        properties.setProperty("spring.jpa.show-sql", env.getProperty("spring.jpa.show-sql"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        sessionFactory.setHibernateProperties(properties);

        return sessionFactory;
    }
}
