package br.com.zup.talents.vacina.repository;

import br.com.zup.talents.vacina.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String emailUsuario);
}
