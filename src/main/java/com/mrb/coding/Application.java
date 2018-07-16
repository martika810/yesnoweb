package com.mrb.coding;

import com.alibaba.dubbo.common.logger.jcl.JclLogger;
import com.baidu.unbiz.easymapper.mapping.ServiceLoaderHelper;
import com.mrb.coding.service.CityService;
import com.mrb.coding.service.SnippetService;
import com.mrb.coding.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot 启动类
 *
 * @author trang
 */
@SpringBootApplication
@MapperScan("com.mrb.coding.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        System.setProperty("dubbo.application.logger", "slf4j");
        System.setProperty("druid.logType", "slf4j");
        ServiceLoaderHelper.getInstance();
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private SnippetService snippetService;

    @Override
    public void run(String... args) throws Exception {
      //  JclLogger log;
      //  log.info("application is running...");
        //log.info();

     //   JsonUtils.toJson(snippetService.selectByPk(1))
    }

}