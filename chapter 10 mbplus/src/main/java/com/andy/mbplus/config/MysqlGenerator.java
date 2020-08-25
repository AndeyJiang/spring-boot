package com.andy.mbplus.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class MysqlGenerator {

    public static void main(String[] args){

        //COde generator
        AutoGenerator mpg=new AutoGenerator();

        /**
         Global configuration
         */

        GlobalConfig gc=new GlobalConfig();
        String projectPath=System.getProperty("user.dir");

        gc.setOutputDir(projectPath+"/src/main/java");

        /**
         TODO Set username
         */
        gc.setAuthor("Andy");
        gc.setOpen(true);

        /**
         Service naming
         */
       // gc.setServiceName("%sService");
       // gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);

        /**
         XML second level cache
         */
        gc.setEnableCache(false);
        /**
         XML result Map
         */
        gc.setBaseResultMap(true);
        /**
         XML column List
         */
        gc.setBaseColumnList(false);
        mpg.setGlobalConfig(gc);

        /**
         TODO  Database configuration
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/shiro?useUnicode=true&autoReconnect=true&characterEncoding=utf-8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("mmyy12345");
        mpg.setDataSource(dsc);

        /**
         Set the corresponding package
         */
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.andy.mbplus");
        pc.setEntity("entity");
        //pc.setService("dao.service");
        //pc.setServiceImpl("dao.serviceImpl");
        mpg.setPackageInfo(pc);

        List<TableFill> tableFillList = new ArrayList<>();

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();

        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        // strategy configuration
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        // set logic delete
        strategy.setLogicDeleteFieldName("deleted");
        //  specify the table name of bean to be generated
        strategy.setInclude("t_permission");
        // Hump to hyphen
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }
}
