package com.mrb.coding.config;

import com.mrb.coding.intercept.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Spring MVC 配置
 *
 * @author trang
 */
@Configuration
public class SpringMvcConfig {


    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurerAdapter() {

            private final String[] CLASSPATH_RESOURCE_LOCATIONS = {
                    "classpath:/META-INF/resources/", "classpath:/resources/",
                    "classpath:/static/", "classpath:/public/" };

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                configurer
                        .setUseSuffixPatternMatch(false)
                        .setUseTrailingSlashMatch(true);
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new TokenInterceptor())
                        //.addPathPatterns("/sign/**")
                        .addPathPatterns("/snippet/**");
            }

            /**
             * 视图分发器配置
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                configurer
                        .favorPathExtension(false)
                        .favorParameter(true)
                        .parameterName("data-format")
                        .ignoreAcceptHeader(true)
                        .mediaType("json", MediaType.APPLICATION_JSON_UTF8)
                        .mediaType("html", MediaType.valueOf("text/html;charset=UTF-8"));
            }


            @Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                configurer.enable();
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/**")
                        .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(false)
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE");
            }

        };
    }

}