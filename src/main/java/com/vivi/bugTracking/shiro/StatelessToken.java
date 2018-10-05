package com.vivi.bugTracking.shiro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationToken;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatelessToken implements AuthenticationToken {
    private Object loginId;

    private Object token;

//    private Map<String, ?> params;

    @Override
    public Object getPrincipal() {
        return getLoginId();
    }

    @Override
    public Object getCredentials() {
        return getToken();
    }
}
