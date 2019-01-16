package com.netintech.xfquartz.cfgbeans;

import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangyue
 * @date: 2019/1/16 16:55
 * @description:
 */
@Configuration
public class MyBatisConfiguration {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new MybatisPlusCustomizers();
    }

    class MybatisPlusCustomizers implements ConfigurationCustomizer {

        @Override
        public void customize(org.apache.ibatis.session.Configuration configuration) {
            configuration.setJdbcTypeForNull(JdbcType.NULL);
        }
    }
}
