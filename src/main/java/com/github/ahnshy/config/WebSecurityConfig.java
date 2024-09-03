package com.github.ahnshy.config;

import com.github.ahnshy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// deprecated
//import com.github.ahnshy.util.TokenRequestFilter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; //deprecated
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
public class WebSecurityConfig {
    @Autowired
    private final UserService userService;
    //deprecated
    //private final TokenRequestFilter tokenRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // deprecated springboot v3.1 over
    //public AuthenticationManager authenticationManagerBean() throws Exception {
        //return super.authenticationManagerBean();
    //}
    //public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    //}
//    public void configure (HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests() // 토큰을 활용하는 경우 모든 요청에 대해 접근이 가능하도록 함
//                .anyRequest().permitAll()
//                .and() // 토큰을 활용하면 세션이 필요 없으므로 STATELESS로 설정하여 Session을 사용하지 않는다.
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and() // form 기반의 로그인에 대해 비활성화 한다.
//                .formLogin()
//                .disable()
//                .addFilterBefore(tokenRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//        http.cors();
//    }
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 인가(접근권한) 설정
        //http.authorizeHttpRequests().antMatchers("/").permitAll();
        //http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN");
        //http.authorizeHttpRequests().antMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER");
        //http.authorizeHttpRequests().antMatchers("/user/loginSuccess").hasAnyRole("3", "4", "5");

        // 사이트 위변조 요청 방지
        http.csrf().disable();

        // 로그인 설정
        http.formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/user/loginSuccess")
                .failureUrl("/user/login?success=100)")
                .usernameParameter("uid")
                .passwordParameter("pass");

        // 로그아웃 설정
        http.logout()
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login?success=200");

        // 사용자 인증 처리 컴포넌트 서비스 등록
        http.userDetailsService(userService);

        return http.build();
    }

}
