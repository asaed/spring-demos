package com.sourceallies.demos.library.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan("com.sourceallies.demos.library")
public class LibraryApplicationConfiguration  {

}
