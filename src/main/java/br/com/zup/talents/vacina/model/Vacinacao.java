package br.com.zup.talents.vacina.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeVacina;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime dataVacina = LocalDateTime.now();

    public Vacinacao(){

    }

    public Vacinacao(String nomeVacina, Usuario usuario){

        this.nomeVacina = nomeVacina;
        this.usuario = usuario;

    }
    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
