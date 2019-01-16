package com.netintech.xfquartz.cfgbeans;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author: zhangyue
 * @date: 2018/11/8 15:52
 * @description:
 */
@Configuration
@MapperScan(basePackages = {"com.netintech.xfquartz.dao.xf110"}, sqlSessionTemplateRef = "xf110SqlSessionTemplate")
public class XF110MybatisConfig {

    @Bean(name = "xf110DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource xf110DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory xf110SqlSessionFactory(@Qualifier("xf110DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/xf110/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "xf110TransactionManager")
    //@Primary
    public DataSourceTransactionManager sentinelTransactionManager(@Qualifier("xf110DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate xf110SqlSessionTemplate(@Qualifier("xf110SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }

}
