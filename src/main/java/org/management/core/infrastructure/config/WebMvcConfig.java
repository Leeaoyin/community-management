package org.management.core.infrastructure.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.management.core.application.interceptor.RequestJsonHandlerArgumentResolver;
import org.management.core.domain.event.Const;
import org.management.core.application.interceptor.AuthenticationInterceptor;
import org.management.core.application.interceptor.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.management.core.domain.event.Const.EMPTY;
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    
    
    @Bean
    public AuthenticationInterceptor loginRequiredInterceptor(){
        return new AuthenticationInterceptor();
    }

    /**
     * JsonParam 参数解析器
     *
     * @return
     */
    @Bean
    public RequestJsonHandlerArgumentResolver requestJsonHandlerArgumentResolver() {
        return new RequestJsonHandlerArgumentResolver();
    }
    
    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver(){
        return new CurrentUserMethodArgumentResolver();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<>(2);
        patterns.add(Const.API_URL + "/login");
        patterns.add(Const.API_URL + "/register");
        registry.addInterceptor(loginRequiredInterceptor())
                .addPathPatterns(Const.API_URL + "/**")
                .excludePathPatterns(patterns);
        super.addInterceptors(registry);
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
//                .addResourceLocations("classpath:/META-INF/resources/webjars")
//                .addResourceLocations("classpath:/static/")
//                .addResourceLocations("classpath:/static/page/")
//                .addResourceLocations("classpath:/static/templates/")
                .addResourceLocations("classpath:/frontend-ui/");

    }


    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonConvert = new GsonHttpMessageConverter();
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        gsonConvert.setSupportedMediaTypes(fastMediaTypes);
        converters.add(gsonConvert);
    }
}
