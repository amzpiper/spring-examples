package guoyuhang.soundsystem;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)

//如果ShoppingCart不是接口的话用TARGET_CLASS(CGLIB代理)
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)

//proxyMode = ScopedProxyMode.INTERFACES
//解决session注入到单例bean中出现的问题
//session一开始不存在
//保证当service使用ShoppingCart时正好是当前会话对应的这个，而不是别的service里的ShoppingCart
public class ShoppingCart {
}
