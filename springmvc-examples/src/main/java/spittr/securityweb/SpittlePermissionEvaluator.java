package spittr.securityweb;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import spittr.model.Spitter;
import spittr.model.Spittle;

import java.io.Serializable;

public class SpittlePermissionEvaluator implements PermissionEvaluator {

    private static final GrantedAuthority ADMIN_AUTHORITY = new GrantedAuthority() {
        @Override
        public String getAuthority() {
            return "ROLE_ADMIN";
        }
    };

    /**
     * 检测评估对象是否为一个spittle，是否为删除权限
     * @param authentication
     * @param target
     * @param permission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        if (target instanceof Spittle) {
            Spittle spittle = (Spittle) target;
            String username = spittle.getSpitter().getUsername();
            if ("delete".equals(permission)) {
                return isAdmin(authentication) || username.equals(authentication.getName());
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        throw new UnsupportedOperationException();
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
    }
}
