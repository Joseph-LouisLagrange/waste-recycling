package com.darwin.wasterecycling.config.security.applet;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class AppletAuthenticationToken extends AbstractAuthenticationToken {

    private String code;

    private String openID;

    private String sessionKey;

    private String unionID;

    public AppletAuthenticationToken(){
        super(null);
    }

    public AppletAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public AppletAuthenticationToken(String code){
        super(null);
        this.code=code;
    }

    @Override
    public Object getCredentials() {
        return code;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public String getCode() {
        return code;
    }
}
