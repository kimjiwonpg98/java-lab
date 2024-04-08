package kr.arch.account.config.database;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.arch")
@EntityScan(basePackages = "kr.arch.entity")
@ComponentScan(basePackages = "kr.arch")
public class MysqlConfig {}
