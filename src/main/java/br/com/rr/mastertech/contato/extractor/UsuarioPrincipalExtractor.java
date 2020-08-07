package br.com.rr.mastertech.contato.extractor;

import br.com.rr.mastertech.contato.dto.request.UsuarioPrincipal;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

import java.util.Map;

public class UsuarioPrincipalExtractor implements PrincipalExtractor {

    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        UsuarioPrincipal usuario = new UsuarioPrincipal();
        usuario.setId((Integer) map.get("id"));
        usuario.setNome(map.get("name").toString());

        return usuario;
    }
}
