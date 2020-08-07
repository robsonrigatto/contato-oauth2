package br.com.rr.mastertech.contato.service;

import br.com.rr.mastertech.contato.domain.Contato;
import br.com.rr.mastertech.contato.domain.Usuario;
import br.com.rr.mastertech.contato.dto.request.CriarContatoRequest;
import br.com.rr.mastertech.contato.dto.request.UsuarioPrincipal;
import br.com.rr.mastertech.contato.dto.response.ContatoResponse;
import br.com.rr.mastertech.contato.mapper.ContatoMapper;
import br.com.rr.mastertech.contato.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoMapper mapper;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ContatoRepository repository;

    public List<ContatoResponse> findAllByUser(UsuarioPrincipal principal) {
        Usuario usuario = usuarioService.findOrCreate(principal);
        List<Contato> allByUsuario = repository.findAllByUsuario(usuario);
        return allByUsuario.stream().map(c -> mapper.toContatoResponse(c)).collect(Collectors.toList());
    }

    @Transactional
    public ContatoResponse create(CriarContatoRequest request, UsuarioPrincipal principal) {
        Usuario usuario = usuarioService.findOrCreate(principal);
        Contato contato = mapper.toContato(request, usuario);
        contato = repository.save(contato);

        return mapper.toContatoResponse(contato);
    }

}
