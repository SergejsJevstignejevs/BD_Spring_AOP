package com.sj.bd_3_exp_prog.application.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.sj.bd_3_exp_prog")
public class AOPConfig {
}
