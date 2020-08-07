package br.com.rr.mastertech.contato.mapper;

import br.com.rr.mastertech.contato.domain.Usuario;
import br.com.rr.mastertech.contato.dto.request.UsuarioPrincipal;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioPrincipal principal) {
        Usuario usuario = new Usuario();
        usuario.setId(principal.getId());
        usuario.setNome(principal.getNome());

        return usuario;
    }

}
