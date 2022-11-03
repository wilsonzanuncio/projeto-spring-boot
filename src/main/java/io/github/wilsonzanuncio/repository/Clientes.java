package io.github.wilsonzanuncio.repository;

import io.github.wilsonzanuncio.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNome(String nome);
}
