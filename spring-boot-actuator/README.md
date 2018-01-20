# spring-boot-actuator

#### 配置
```
logging:
  level:
    root: info
# 启用 actuator，并允许执行关机命令
endpoints:
  actuator:
    enabled: true
  shutdown:
    enabled: true
server:
  port: 80
spring:
  profiles:
    active: default
# `/info` 端点输出信息(info.***)
info:
  author: zlikun
  version: v1.0.0
  tags:
    - spring
    - hadoop
    - docker
# 禁用管理安全机制才能访问全部端点(除：/health和/info之外)
management:
  security:
    enabled: false
```

#### 端点
- 应用配置类
    - GET /autoconfig
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/autoconfig.json>
        - > 获取应用自动化配置报告，包括所有自动化配置候选项，同时列出每个候选项自动化配置的各个先决条件是否满足,报告内容将自动化配置内容分成两个部分：
            - `positiveMatches` 中返回的是条件匹配成功的自动化配置
            - `negativeMatches` 中返回的是条件匹配不成功的自动化配置
    - GET /configprops
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/configprops.json>
        - > 该端点用来获取应用中配置的属性信息报告
    - GET /beans
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/beans.json>
        - > 该端点用来获取应用上下文中创建的所有Bean，每个Bean由下面几部分构成：
            - `bean` Bean的名称
            - `scope` Bean的作用域
            - `type` Bean的Java类型
            - `resource` class文件的具体路径
            - `dependencies` 依赖的Bean名称
    - GET /mappings
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/mappings.json>
        - > 该端点用来返回所有Spring MVC的控制器映射关系报告
    - GET /info
        - > 该端点用来返回一些应用自定义的信息，可以在`application.properties`配置文件中通过`info`前缀来设置一些属性
        ```json
        {"author":"zlikun","version":"v1.0.0","tags":{"0":"spring","1":"hadoop","2":"docker"}}
        ```
    - GET /env
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/env.json>
        - > 该端点用来获取应用所有可用的环境属性报告
    - GET /env/user.home
    ```json
    {"user.home":"C:\\Users\\Administrator"}
    ```
    - GET /health
        - > 该端点用来获取应用的各类健康指标信息
    ```json
    {"status":"UP","diskSpace":{"status":"UP","total":31983661056,"free":27655364608,"threshold":10485760}}
    ```
- 度量指标类
    - GET /metrics
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/metrics.json>
        - > 该端点用来返回当前应用的各类重要度量指标，比如：内存信息、线程信息、垃圾回收信息等
    - GET /metrics/mem
        - > 获取当个度量指标的信息
        ```json
        {"mem":283926}
        ```
    - GET /dump
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/dump.json>
        - > 该端点用来暴露程序运行中的线程信息
    - GET /trace
        - <https://github.com/zlikun-spring/spring-boot/blob/master/spring-boot-actuator/doc/trace.json>
        - > 该端点用来返回基本的HTTP跟踪信息
- 操作控制类
    - POST /shutdown
    ```
    # 关闭应用，需要配置：endpoints.actuator.shutdown=rue
    $ curl -i -X POST http://localhost/shutdown
      % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                     Dload  Upload   Total   Spent    Left  Speed
    100    35    0    35    0     0   2187      0 --:--:-- --:--:-- --:--:-- 35000HTTP/1.1 200
    X-Application-Context: application:default:80
    Content-Type: application/vnd.spring-boot.actuator.v1+json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Sat, 20 Jan 2018 04:28:05 GMT
    
    {"message":"Shutting down, bye..."}
    ```
    
#### 参考
- 《spring-boot-reference》
- 《Spring Boot in Action》
- <http://blog.didispace.com/spring-boot-actuator-1/>