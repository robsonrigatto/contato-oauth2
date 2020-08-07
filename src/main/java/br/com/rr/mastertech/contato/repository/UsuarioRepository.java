package br.com.rr.mastertech.contato.repository;

import br.com.rr.mastertech.contato.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}
