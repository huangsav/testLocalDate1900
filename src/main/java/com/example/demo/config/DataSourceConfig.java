package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.example.demo.mapper", sqlSessionTemplateRef = "lycaijingSqlSessionTemplate")
public class DataSourceConfig {
    @Bean(name = "lycaijingDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource lycaijingDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "lycaijingSqlSessionFactory")
    @Primary
    public SqlSessionFactory lycaijingSqlSessionFactory(@Qualifier("lycaijingDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "lycaijingTransactionManager")
    @Primary
    public DataSourceTransactionManager lycaijingTransactionManager(@Qualifier("lycaijingDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "lycaijingSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate lycaijingSqlSessionTemplate(@Qualifier("lycaijingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
