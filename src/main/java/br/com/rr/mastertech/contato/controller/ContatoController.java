package br.com.rr.mastertech.contato.controller;

import br.com.rr.mastertech.contato.domain.Usuario;
import br.com.rr.mastertech.contato.dto.request.CriarContatoRequest;
import br.com.rr.mastertech.contato.dto.request.UsuarioPrincipal;
import br.com.rr.mastertech.contato.dto.response.ContatoResponse;
import br.com.rr.mastertech.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping("/contatos")
    public List<ContatoResponse> findAllByUser(@AuthenticationPrincipal UsuarioPrincipal principal) {
        return service.findAllByUser(principal);
    }

    @PostMapping("/contato")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContatoResponse create(@RequestBody CriarContatoRequest request, @AuthenticationPrincipal UsuarioPrincipal principal) {
        return service.create(request, principal);
    }

}
