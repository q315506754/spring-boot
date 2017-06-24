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


