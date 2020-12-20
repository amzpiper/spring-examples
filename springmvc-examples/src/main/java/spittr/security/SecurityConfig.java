package spittr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import spittr.data.SpittleRepository;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configurebyMemory(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and().
                withUser("").password("").authorities("ROLE_USER");
    }

    @Autowired
    DataSource dataSource;
    protected void configurebyDataSource(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, true" +
                "from Spitter where username=?")
        .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
        .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }

    protected void configurebyLDAP(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("")
                .groupSearchFilter("")
                .contextSource().url("");
    }

    @Autowired
    private SpittleRepository spittleRepository;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new SpitterUserService(spittleRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/spitters/me").hasRole("SPITTER")
                .antMatchers(HttpMethod.POST, "").access("hasRole('ROLE_SPITTER')")
                .antMatchers(HttpMethod.POST, "").access("hasIpAddress('192.168.0.1')")
                .regexMatchers("/spitters/.*").authenticated()
                .anyRequest().permitAll();
        http.csrf().disable();
        http.formLogin().and()
                .authorizeRequests()
                    .antMatchers("").hasRole("")
                    .anyRequest().permitAll();
        http.formLogin().loginPage("/")
                .and()
                .httpBasic()
                .realmName("");
        http.formLogin().loginPage("/")
                .and().rememberMe().tokenValiditySeconds(22).key("123");
        http.logout().logoutSuccessUrl("/logout").logoutUrl("/");
    }
}
