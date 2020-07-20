package com.mp.study.bilibilimybatisplus;

/**
 * 打包部署：
 * 点击右侧 Maven 选项卡 lifecycle=>package
 *
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mp.study.bilibilimybatisplus.mapper")
@SpringBootApplication
public class BilibiliMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilibiliMybatisPlusApplication.class, args);
    }

}
