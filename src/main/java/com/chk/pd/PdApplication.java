package com.chk.pd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
@MapperScan(basePackages = "com.chk.pd.**.dao")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class PdApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdApplication.class, args);
    }
}
