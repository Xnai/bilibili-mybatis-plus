package com.mp.study.bilibilimybatisplus.generator;

/**
 * 使用此类可以完整的将所有的表均生成entity,Service,ServiceImpl,Controller，
 */

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Main {
    public static void main(String[] args) {
        // 创建Generator对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE);
        dataSourceConfig.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSourceConfig.setUsername("");
        dataSourceConfig.setPassword("");
        dataSourceConfig.setDriverName("");

        autoGenerator.setDataSource(dataSourceConfig);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
                                // 当前工程的绝对路径
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setOpen(false); // 创建建好之后是否自动打开文件夹
        globalConfig.setServiceName("%sService"); // 此设置设定接口命名不带 I
        globalConfig.setAuthor(""); //生成者的署名，默认计算机名

        //包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.mp.study.bilibilimybatisplus"); // 父包名
        packageConfig.setModuleName("generator"); // 模块名
        packageConfig.setService("service"); // service类
        packageConfig.setServiceImpl("service.impl"); //serviceImpl类
        packageConfig.setMapper("mapper"); //mapper接口
        packageConfig.setEntity("entity"); // 实体类

        autoGenerator.setPackageInfo(packageConfig);

        // 配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true); // 为实体自动添加lombok注解
        strategyConfig.setNaming(NamingStrategy.underline_to_camel); // 驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel); // 下划线字段名变为驼峰命名

        strategyConfig.setInclude("表名1","表名2","表名3"); //生成部分表的生成代码

        autoGenerator.setStrategy(strategyConfig);

        // 启动，执行生成
        autoGenerator.execute();

    }
}
