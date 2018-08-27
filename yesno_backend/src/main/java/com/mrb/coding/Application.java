package com.mrb.coding;

import com.baidu.unbiz.easymapper.mapping.ServiceLoaderHelper;
import com.mrb.coding.service.SnippetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBoot 启动类
 *
 * @author trang
 */
@SpringBootApplication
//@MapperScan("com.mrb.coding.mapper")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
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