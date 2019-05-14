package com.sgcc.epri.dataexchangeplatform.Datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wmq
 * @date ：Created in 2019/2/21 10:38
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Configuration
//@PropertySource("classpath:application.properties")
public class ConfigurationDataSource {
    @Autowired
    private Environment env;

    @Bean()
    //@Primary
    @ConfigurationProperties(prefix = "spring.datasource.informix")
    public DataSource primaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("driver-class-name"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }

    @Bean()
    @ConfigurationProperties(prefix = "spring.datasource.dm6")
    public DataSource dmDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("driver-class-name"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }
    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dmDataSource") DataSource dmDataSource,
                                               @Qualifier("primaryDataSource") DataSource primaryDataSource) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();


        fb.setDataSource(this.dataSource(dmDataSource,primaryDataSource));//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setConfigLocation(
                new ClassPathResource("mybatis-config.xml"));
        //fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//指定xml文件位置
        return fb.getObject();
    }
    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("dmDataSource") DataSource dmDataSource,
                                        @Qualifier("primaryDataSource") DataSource primaryDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("DM6", dmDataSource);
        targetDataSources.put("INFORMIX", primaryDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(primaryDataSource);// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }
}
