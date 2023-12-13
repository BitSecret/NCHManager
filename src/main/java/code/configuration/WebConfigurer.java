package code.configuration;

import code.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){    //拦截器配置
        log.info("配置拦截器");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")      //一定要加/ 不然拦截器失效
                .excludePathPatterns("/home", "/login", "/general_list", "/error",   //无需拦截的页面请求
                        "/dist/**", "/js/**", "/plugins/**", "/img/**",   //无需拦截的资源
                        "/data_api/**", "/data_api/getIchInfo");    //无需拦截的数据查询端口
    }


//    @Bean
//    public ObjectMapper objectMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        JavaTimeModule javaTimeModule = new JavaTimeModule();    //日期与时间格式配置
//        javaTimeModule.addSerializer(LocalDateTime.class,
//                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        javaTimeModule.addSerializer(LocalDate.class,
//                new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        javaTimeModule.addSerializer(LocalTime.class,
//                new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
//        objectMapper.registerModule(javaTimeModule);
//
//        return objectMapper;
//    }
}