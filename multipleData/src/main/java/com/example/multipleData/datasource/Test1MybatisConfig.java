package com.example.multipleData.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;


@Configuration("test1MybatisConfig")
@MapperScan(basePackages="com.example.multipleData.dao.test1",sqlSessionFactoryRef="test1SqlSessionFactory")
public class Test1MybatisConfig {
    //配置数据源
    @Primary
    @Bean(name="test1Datasource")
    public DataSource testDatasource(DBConfig1 config1) throws SQLException {
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setUrl(config1.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(config1.getPassword());
        mysqlXADataSource.setUser(config1.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("test1Datasource");

        atomikosDataSourceBean.setMinPoolSize(config1.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(config1.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(config1.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(config1.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(config1.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(config1.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(config1.getMaxIdleTime());
        return atomikosDataSourceBean;
    }
    @Primary
    @Bean(name="test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1Datasource")DataSource dataSource) 
            throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //配置mapper.xml文件所在位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

	@Primary
    @Bean(name="test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory")
    SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
