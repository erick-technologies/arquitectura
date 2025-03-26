package com.bim.sief.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permitir todas las rutas
                        .allowedOrigins("http://localhost:4200") // Permitir el origen de Angular
                        .allowedMethods(
                                Request.HttpMethod.GET.name(),
                                Request.HttpMethod.POST.name(),
                                Request.HttpMethod.PUT.name(),
                                Request.HttpMethod.DELETE.name(),
                                Request.HttpMethod.OPTIONS.name()) // Métodos permitidos
                        .allowedHeaders(HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION)// Permitir todos los encabezados
                        .allowCredentials(true); // Permitir credenciales
            }
        };
    }

}

/*En caso de usar spring security
*
* import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and() // Habilitar CORS
            .csrf().disable() // Deshabilitar CSRF para simplificar
            .authorizeRequests()
            .antMatchers("/login", "/authenticate").permitAll() // Permitir acceso sin autenticación
            .anyRequest().authenticated(); // Requiere autenticación para otras solicitudes
    }
}
*
*
*
*
* */