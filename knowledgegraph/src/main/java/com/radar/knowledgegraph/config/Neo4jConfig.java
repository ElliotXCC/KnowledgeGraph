package com.radar.knowledgegraph.config;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//注解@EnableNeo4jRepositories用来开启Neo4j的仓库功能
@EnableNeo4jRepositories(basePackages = "com.radar.knowledgegraph.repository")
//注解@EnableTransactionManagement用来支持事务
@EnableTransactionManagement
public class Neo4jConfig {

    @Value("${spring.data.neo4j.uri}")
    private String url;

    @Value("${spring.data.neo4j.username}")
    private String username;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Bean(name = "session")
    public Session neo4jSession() {
        Driver driver = GraphDatabase.driver(url, AuthTokens.basic(username, password));
        return driver.session();
    }

//    @Bean
//    public SessionFactory sessionFactory() {
//        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
//                .uri(url)
//                .credentials(username, password)
//                .build();
//        return new SessionFactory(configuration, "com.neo4j.demo.entity");
//    }
//
//    @Bean
//    public Neo4jTransactionManager transactionManager() {
//        return new Neo4jTransactionManager(sessionFactory());
//    }

}