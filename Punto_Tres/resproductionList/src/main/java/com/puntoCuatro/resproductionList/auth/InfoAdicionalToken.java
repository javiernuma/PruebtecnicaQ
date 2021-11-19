package com.puntoCuatro.resproductionList.auth;


import com.puntoCuatro.resproductionList.models.Usuario;
import com.puntoCuatro.resproductionList.services.IAuthUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private IAuthUsuarioService authUsuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Usuario usuario = authUsuarioService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("login_usuario", authentication.getName());
        info.put("nombre_usuario",  usuario.getNombre());
        info.put("apellido_usuario",  usuario.getApellido());
        info.put("id_usuario",  usuario.getId());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
