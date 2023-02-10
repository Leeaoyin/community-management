package org.management.core.infrastructure.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "org.management.core.infrastructure.repository.mapper",
        sqlSessionFactoryRef = "aliceSqlSessionFactory")
public class ORMConfig {
    @Autowired
    private PageInterceptor pageInterceptor;

    @Bean(name = "cmDataSource")
    @ConfigurationProperties(prefix = "dataplatform.cm.db.conn")
    public DataSource ruleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cmSqlSessionFactory")
    public SqlSessionFactory aliceSqlSessionFactory(@Qualifier("cmDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        sqlSessionFactoryBean.setTypeAliasesPackage("org.management.core.infrastructure.repository.po");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*Mapper.xml"));
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/cm-mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "cmTransactionManager")
    public DataSourceTransactionManager aliceTransactionManager(@Qualifier("cmDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
