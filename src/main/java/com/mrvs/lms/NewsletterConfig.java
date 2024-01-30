package com.mrvs.lms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = {"org.mrvs.lms.jpaOneModel","org.mrvs.lms.jpaOneRepository"},
        entityManagerFactoryRef="getNewsLetterEm",
        transactionManagerRef="newsLetterTxnManager")

public class NewsletterConfig {
    @Bean
    @ConfigurationProperties(
            prefix = "newsletter.datasource"
    )
    public DataSource getAuthorDs(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean getNewsLetterEm(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getAuthorDs());
        em.setPackagesToScan("org.mrvs.lms.model", "org.mrvs.lms.jpaOneMode");

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        em.setJpaPropertyMap(properties);
        return em;
    }
    @Bean
    public PlatformTransactionManager newsLetterTxnManager(){
        JpaTransactionManager txnManager = new JpaTransactionManager();
        txnManager.setEntityManagerFactory(getNewsLetterEm().getObject());
        return txnManager;
    }
}
