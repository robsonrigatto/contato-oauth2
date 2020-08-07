package br.com.rr.mastertech.contato.service;

import br.com.rr.mastertech.contato.domain.Usuario;
import br.com.rr.mastertech.contato.dto.request.UsuarioPrincipal;
import br.com.rr.mastertech.contato.mapper.UsuarioMapper;
import br.com.rr.mastertech.contato.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario findOrCreate(UsuarioPrincipal usuarioPrincipal) {
        Optional<Usuario> byId = repository.findById(usuarioPrincipal.getId());

        if(byId.isPresent()) return byId.get();

        Usuario usuario = mapper.toUsuario(usuarioPrincipal);
        usuario = repository.save(usuario);

        return usuario;
    }
}
