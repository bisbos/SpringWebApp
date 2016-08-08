package com.quicken.config;

import com.quicken.common.core.authentication.QcsAuthenticationDisabled;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bbose on 8/3/16.
 */
@Configuration
@EnableResourceServer
public class SecurityConfiguration extends ResourceServerConfigurerAdapter{

    public void configure(HttpSecurity http) throws Exception {
        ArrayList URIs = new ArrayList();
        URIs.add("/static/**");
        URIs.add("/webjars/**");
        URIs.add("/urls/**");
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Controller.class));
        Iterator var4 = scanner.findCandidateComponents("com.quicken").iterator();
        while(var4.hasNext()) {
            BeanDefinition beanDefinition = (BeanDefinition)var4.next();
            Class controllerClass = Class.forName(beanDefinition.getBeanClassName());
            Method[] var7 = controllerClass.getDeclaredMethods();
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                Method method = var7[var9];
                Annotation authAnnotation = method.getAnnotation(QcsAuthenticationDisabled.class);
                if(authAnnotation != null) {
                    Annotation annotation = method.getAnnotation(RequestMapping.class);
                    if(annotation != null) {
                        URIs.add(((RequestMapping)annotation).value()[0]);
                    }
                }
            }
        }

        ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().antMatchers((String[])URIs.toArray(new String[URIs.size()]))).permitAll().anyRequest()).authenticated();
    }


}
