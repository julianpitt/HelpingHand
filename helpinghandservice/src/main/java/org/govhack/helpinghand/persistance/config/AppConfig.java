package org.govhack.helpinghand.persistance.config;

import org.govhack.helpinghand.persistance.entities.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * Created by James on 31-Jul-16.
 */
@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }
    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClasses(LocalityEntity.class)
                .addAnnotatedClasses(LocalityTrendEntity.class)
                .addAnnotatedClasses(LocalityUsageEntity.class)
                .addAnnotatedClasses(StateEntity.class)
                .addAnnotatedClasses(StateTrendEntity.class)
                .addAnnotatedClasses(StateUsageEntity.class)
                .addAnnotatedClasses(StreetEntity.class)
                .addAnnotatedClasses(StreetTrendEntity.class)
                .addAnnotatedClasses(StreetUsageEntity.class)
                .addAnnotatedClasses(SuburbEntity.class)
                .addAnnotatedClasses(SuburbUsageEntity.class)
                .addAnnotatedClasses(SuburbTrendEntity.class)
                .addAnnotatedClasses(TrendTypeEntity.class)
                .addAnnotatedClasses(UsageTypeEntity.class)
                .buildSessionFactory();
    }
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/helperhand");
        dataSource.setUsername("helperhanddb");
        dataSource.setPassword("Y7g+,ZJ3j7i");

        return dataSource;
    }
    @Bean
    public HibernateTransactionManager hibTransMan(){
        return new HibernateTransactionManager(sessionFactory());
    }
}