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
- GET /autoconfig
- GET /configprops
- GET /beans
- GET /dump
- GET /env
- GET /env/user.home
```json
{"user.home":"C:\\Users\\Administrator"}
```
- GET /health
```json
{"status":"UP","diskSpace":{"status":"UP","total":31983661056,"free":27655364608,"threshold":10485760}}
```
- GET /info
```json
{"author":"zlikun","version":"v1.0.0","tags":{"0":"spring","1":"hadoop","2":"docker"}}
```
- GET /mappings
- GET /metrics
- GET /metrics/mem
```json
{"mem":283926}
```
- GET /metrics
- POST /shutdown
