package br.com.rr.mastertech.contato.repository;

import br.com.rr.mastertech.contato.domain.Contato;
import br.com.rr.mastertech.contato.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {

    List<Contato> findAllByUsuario(Usuario usuario);
}
