package spittr.securityweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityWebConfig extends GlobalMethodSecurityConfiguration {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("").roles("");
    }
    
    /**
     * 注册自定义的hasPermission计算器
     * @return
     */
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new SpittlePermissionEvaluator());
        return expressionHandler;
    }
}
