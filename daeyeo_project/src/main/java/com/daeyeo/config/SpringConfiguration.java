package com.daeyeo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.daeyeo")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.daeyeo.persistence",
        entityManagerFactoryRef = "factoryBean",
        transactionManagerRef = "txManager")
public class SpringConfiguration {
    @Bean
    public HibernateJpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/DaeyeoProject?useSSL=False");
        dataSource.setUsername("root");
        dataSource.setPassword("0870");
        dataSource.setMaximumPoolSize(11);
        dataSource.setMinimumIdle(10);
        dataSource.setConnectionTimeout(1000);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean factoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(vendorAdapter());
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.daeyeo.entity");
//        factoryBean.setPersistenceUnitName("a");

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.id.new_generator_mappings", "true");
        properties.put("hibernate.hbm2ddl.auto", "validate");

        factoryBean.setJpaPropertyMap(properties);
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager txManager(EntityManagerFactory factory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(factory);
        return txManager;
    }
}
