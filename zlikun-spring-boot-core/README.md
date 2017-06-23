#### 定制启动Banner
```
# 在 src/main/resources/ 目录下放一个名为banner.txt的文本文件，该文件中的内容将替换默认启动Banner
# 如果希望对文字美化，可以使用一个在线工具：http://patorjk.com/software/taag，本例文本内容为：ZLIKUN.COM
# 默认Banner文本：
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.4.RELEASE)
```

#### 全局配置文件
```
# application.properties 或 application.yml (使用yaml语法编写)

# application.properties 示例
server.port = 8080
server.context-path = /

# application.yml 示例
server:
    port: 8080
    context-path: /
    
# 在配置文件中配置的属性，可以使用@Value直接使用
```

#### [starter pom](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter-poms)


#### 命令行参数
```
$ java -jar xxx.jar
$ java -jar xxx.jar --server.port=8080
```

