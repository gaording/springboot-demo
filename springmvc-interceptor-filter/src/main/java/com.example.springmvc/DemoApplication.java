package com.example.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
    }


    @GetMapping("/test")
    @ResponseBody
    public Test test() {
        return new Test("1111");
    }


    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/a"), request -> ServerResponse.status(HttpStatus.OK).body("hello world"));
    }

//    @Bean
    public WebMvcConfigurer myWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(myHandlerInterceptor1());
                registry.addInterceptor(myHandlerInterceptor2());
            }
        };
    }

    public HandlerInterceptor myHandlerInterceptor1() {
        return new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截器1preHandler。。。。");
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                System.out.println("拦截器1postHandle。。。。");
                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                System.out.println("拦截器1afterCompletion。。。。");
                HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
            }
        };
    }

    public HandlerInterceptor myHandlerInterceptor2() {
        return new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截器2preHandler。。。。");
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                System.out.println("拦截器2postHandle。。。。");
                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                System.out.println("拦截器2afterCompletion。。。。");
                HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
            }
        };
    }

}
