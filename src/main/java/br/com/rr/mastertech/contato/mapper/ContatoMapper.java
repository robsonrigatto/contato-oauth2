package br.com.rr.mastertech.contato.mapper;

import br.com.rr.mastertech.contato.domain.Contato;
import br.com.rr.mastertech.contato.domain.Usuario;
import br.com.rr.mastertech.contato.dto.request.CriarContatoRequest;
import br.com.rr.mastertech.contato.dto.response.ContatoResponse;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public Contato toContato(CriarContatoRequest request, Usuario usuario) {
        Contato contato = new Contato();
        contato.setNome(request.getNome());
        contato.setUsuario(usuario);

        return contato;
    }

    public ContatoResponse toContatoResponse(Contato contato) {
        ContatoResponse response = new ContatoResponse();
        response.setId(contato.getId());
        response.setNome(contato.getNome());
        response.setIdUsuario(contato.getUsuario().getId());
        response.setNomeUsuario(contato.getUsuario().getNome());

        return response;
    }
}
