# XiaoMiStore

## 简介

基于MVC模型并使用JSP对小米商城进行简单的临摹。实现商城的登录注册功能、商品详情、用户信息的修改删减等。

* 注册-MD5加密存储
* 登录-验证码校验
* 用户信息修改
* 商品列表-分页

## 技术栈介绍

* 开发模型：MVC
* 开发语言：JDK8+HTML+CSS
* 数据库： MySQL 8.x
* 数据库连接池：c3p0
* JSON序列化：Jackson
* 日志：commons-logging
* 部署：Tomcat9

## 项目文档

**｜— src Model&Contrller层**

​ -----｜— entity 数据持久层 JavaBean

​ -----｜— dao 数据访问层

​ -----｜— service 业务层

​ -----｜— servlet 控制层

​ -----｜— util 工具包

**｜— web View层**

​ -----｜— error 自定义错误业

​ -----｜— resource 静态资源包

​ -----｜— css

​ -----｜— image

​ -----｜— jquery

​ -----｜— sql

​ -----｜— WEB-INF WEB应用的安全目录

​ ----------｜— lib 依赖资源

## 项目启动

### 初始化数据库

1. 下载 `mysql 8+`
2. 新建数据库`xiaomistore`
3. 初始化表结构：将项目文件下的`src/resource/sql`中的sql包导入数据库`xiaomistore`
4. 根据本地的数据库信息修改数据连接文件`c3p0-config.xml`，默认连接配置名为`xiaomistore`的配置项

### 启动

1. **方式一：原生tomcat**

   打好项目war包 然后放到tomcat目录下的webapps文件夹中，使用catalina run/catalina start 启动项目

2. **方式二：idea启动**

   项目启动配置如下

   ![image-20211116190253252](https://cdn.jsdelivr.net/gh/1065464173/markdown-image-rep/20211116190253.png)

3. **方式三：Eclipse**

   

