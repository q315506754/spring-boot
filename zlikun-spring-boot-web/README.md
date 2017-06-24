#### 常用 ViewResolver
- ContentNegotiatingViewResolver 代理给不同的ViewResolver来处理不同的View，拥有最高的优先级
- BeanNameViewResolver 根据视图名称，查找匹配的ViewResolver
```
@Bean
public MappingJackson2JsonView jsonView() {
    MappingJackson2JsonView jsonView = new MappingJackson2JsonView() ;
    return jsonView ;
}

@RequestMapping("/json")
public String json(Model model) {
    model.addAttribute("name" ,"zlikun") ;
    // 这里的返回的视图名称，与上面定义的视图Bean匹配，那么将由上面的视图Bean来处理该视图
    return "jsonView" ;
}
```
- InternalResourceViewResolver 主要通过设置前缀、后缀，以及控制器中方法返回视图名字符串，以得到实际页面


#### SSL 配置
```
# 生成自签名证书，口令：vvvvvv
$ keytool -genkey -alias *.zlikun.com -keyalg RSA -keysize 2048 -keystore .keystore -validity 3650
输入密钥库口令:
再次输入新口令:
您的名字与姓氏是什么?
  [Unknown]:  *.zlikun.com
您的组织单位名称是什么?
  [Unknown]:  zlikun.com
您的组织名称是什么?
  [Unknown]:  zlikun.com
您所在的城市或区域名称是什么?
  [Unknown]:  SH
您所在的省/市/自治区名称是什么?
  [Unknown]:  SH
该单位的双字母国家/地区代码是什么?
  [Unknown]:  CN
CN=*.zlikun.com, OU=zlikun.com, O=zlikun.com, L=SH, ST=SH, C=CN是否正确?
  [否]:  y

输入 <*.zlikun.com> 的密钥口令
        (如果和密钥库口令相同, 按回车):

# 将生成的.keystore文件复制到工程根目录下，配置 SSL

```