package com.mrb.coding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class UiWebConfig implements WebMvcConfigurer {

    private final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/templates/", "classpath:/public/" ,"classpath:/templates/"};

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }



    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
       // registry.addViewController("/").setViewName("forward:/index");
        registry.addViewController("/sign/index");
        registry.addViewController("login");
        registry.addViewController("header");
        registry.addViewController("/sign/header");
        registry.addViewController("index");

    }


    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/public/**").addResourceLocations("/resources/templates/public/**");
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

}
