package com.example.AutoBase.configuration;

import com.example.AutoBase.service.userdetailsservice.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // наш сервис который переопределяет базовую реализацию для авторизации
    @Autowired
    private UserDetailsServiceImpl userDetailsService;  // для получения информации о польз. при аутентификации

    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;  // кастомная точка входа для базовой аутентификации

    // метод создает бин для объекта BCryptPasswordEncoder (шифратор паролей)
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    // настраивает Spring Security для работы с кастомной логикой аутентификации
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // userDetailsService — компонент, который будет загружать информацию о пользователях при аутентификации
        // passwordEncoder — компонент, который будет шифровать пароли перед их сравнением
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // http.authorizeRequests() - определяет, что будет настраиваться авторизация запросов
        // mvcMatchers() - применяет правило авторизации к конечной точке, возвращ. URL (например, "/admin/settings"), который необходимо защитить
        // access("hasAnyRole('ROLE_ADMIN')") - доступ к конечной точке будет разрешен только польз. с ролью ROLE_ADMIN
        // exceptionHandling() - позволяет настроить обработку исключений, которые возникают во время аутентификации или авторизации
        // authenticationEntryPoint() - задаёт точку входа для аутентификации

        // для всех пользователей
        List<Endpoints> endpointsForAll = Endpoints.getEndpointForAllUsers();
        for (var endpoint : endpointsForAll) {
            http.authorizeRequests().mvcMatchers(endpoint.getEndPoint()).permitAll();
        }

        // для админов
        List<Endpoints> endpointsForAdmin = Endpoints.getEndpointForAdmin();
        for (var endpoint : endpointsForAdmin) {
            http.authorizeRequests().mvcMatchers(endpoint.getEndPoint())
                    .access("hasAnyRole('ROLE_ADMIN')");
        }

        // для авторизованных пользователей и админов
        List<Endpoints> endpointsForAdminAndUser = Endpoints.getEndpointForAdminAndAuthUser();
        for (var endpoint : endpointsForAdminAndUser) {
            http.authorizeRequests().mvcMatchers(endpoint.getEndPoint())
                    .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        }

        // если польз. не аутентифицирован и пытается получить доступ к защищённому ресурсу, то authenticationEntryPoint
        // перехватывает запрос и перенаправляет его для выполнения процедуры аутентификации
        http.authorizeRequests().and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        // конфигурируем процесс входа и выхода
        http.authorizeRequests().and().formLogin()  // активирует механизм аутентификации через форм
                .loginProcessingUrl("/j_spring_security_check")  // URL обрабатывает запросы на аутентификацию
                .loginPage("/login")  // URL, на которую будет перенаправ. польз, если он не авторизован или ему требуется ввести свои учетные данные
                .defaultSuccessUrl("/userInfo")  // URL, на который польз. будет перенаправлен после успешного входа в систему
                .failureUrl("/login?error=true")  // URL для перенаправления в случае неудачного входа
                .usernameParameter("name")  // устанавливает имя параметра для поля имени пользователя в форме
                .passwordParameter("password")  // устанавливает имя параметра для поля пароля в форме
                .and().logout()  // переход к настройке процесса выхода из системы
                    .logoutUrl("/logout")  // URL для выхода из системы (Spring Security автоматически завершает сессию)
                    .logoutSuccessUrl("/logoutSuccessful");  // URL для перенаправления после успешного выхода из системы
    }
}
