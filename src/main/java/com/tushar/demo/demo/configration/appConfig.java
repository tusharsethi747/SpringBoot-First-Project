package com.tushar.demo.demo.configration;

import com.tushar.demo.demo.DevDB;
import com.tushar.demo.demo.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.tushar.demo.demo.DB;
import org.modelmapper.ModelMapper;
import javax.naming.Name;


@Configuration
public class appConfig {

    @Bean
    @ConditionalOnProperty(name="project.mode", havingValue="production")
    public DB getProdBean(){
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name="project.mode", havingValue = "development")
    public DB getDevBean(){
        return new DevDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
