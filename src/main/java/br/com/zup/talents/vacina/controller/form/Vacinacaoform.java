package br.com.zup.talents.vacina.controller.form;


import br.com.zup.talents.vacina.model.Usuario;
import br.com.zup.talents.vacina.model.Vacinacao;
import br.com.zup.talents.vacina.repository.UsuarioRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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


    public Vacinacao converter(UsuarioRepository usuarioRepository) {

        Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
        return new Vacinacao(nomeVacina, usuario);
    }
}
