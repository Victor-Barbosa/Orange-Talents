package br.com.zup.talents.vacina.controller;

import br.com.zup.talents.vacina.controller.form.Vacinacaoform;
import br.com.zup.talents.vacina.model.Usuario;
import br.com.zup.talents.vacina.model.Vacinacao;
import br.com.zup.talents.vacina.repository.UsuarioRepository;
import br.com.zup.talents.vacina.repository.VacinacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {

    private final UsuarioRepository usuarioRepository;

    private final VacinacaoRepository vacinacaoRepository;

    public Controller(UsuarioRepository usuarioRepository, VacinacaoRepository vacinacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.vacinacaoRepository = vacinacaoRepository;
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> cadastraUsuario(@RequestBody @Valid Usuario usuario) {

        try {
            return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/vacina")
    public ResponseEntity<Vacinacao> vacinaAplicada(@RequestBody @Valid Vacinacaoform form) {

        return form.converter(usuarioRepository, vacinacaoRepository);
    }
}
