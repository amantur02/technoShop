//package technoshop.java1902.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("1234").roles("ADMIN").and()
//                .withUser("user").password("4566").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/phones").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/phones").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/phones").hasRole("USER")
//                .antMatchers(HttpMethod.DELETE, "/phones").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/user").hasRole("USER")
//                .and().csrf().disable()
//                .cors();
//    }
//}
