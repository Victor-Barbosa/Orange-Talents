package br.com.zup.talents.vacina.controller.form;


import br.com.zup.talents.vacina.model.Usuario;
import br.com.zup.talents.vacina.model.Vacinacao;
import br.com.zup.talents.vacina.repository.UsuarioRepository;
import br.com.zup.talents.vacina.repository.VacinacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class Vacinacaoform {

    @NotBlank
    private String nomeVacina;

    @Email
    private String emailUsuario;

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public ResponseEntity<Vacinacao> converter(UsuarioRepository usuarioRepository,
                                               VacinacaoRepository vacinacaoRepository) {

        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByEmail(emailUsuario));
        Usuario usuario1 = usuarioRepository.findByEmail(emailUsuario);
        if (usuario.isPresent()) {
            vacinacaoRepository.save(new Vacinacao(nomeVacina, usuario1));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}