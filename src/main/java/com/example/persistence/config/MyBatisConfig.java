package com.example.persistence.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
// Mapperインタフェースのパッケージ名を指定する
@MapperScan(basePackages = "com.example.persistence.mapper")
public class MyBatisConfig {

    /**
     * SqlSessionFactoryBeanをBean定義すると、
     * 実際にはSqlSessionFactoryBean#getObject()の
     * 戻り値SqlSessionFactoryがBean定義される。
     *
     * @param dataSource 他のJavaConfigでBean定義されたDataSource
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // DataSourceをセットする
        factoryBean.setDataSource(dataSource);
        // エンティティクラスのパッケージ名を、エイリアスのパッケージ名として指定する
        factoryBean.setTypeAliasesPackage("com.example.persistence.entity");
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        // 検索時に、列名のアンダースコア区切りをキャメルケースに自動変換する
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        return factoryBean;
    }

}
