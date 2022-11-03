package io.github.wilsonzanuncio;

import io.github.wilsonzanuncio.domain.Cliente;
import io.github.wilsonzanuncio.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando novos clientes");
            clientes.save(new Cliente("Wilson"));
            Cliente arisca = new Cliente("Arisca");
            clientes.save(arisca);

            System.out.println("Buscando todos os clientes");
            List<Cliente> listaClientes = clientes.findAll();
            listaClientes.forEach(System.out::println);

            System.out.println("Atualizando nome dos clientes");
            listaClientes.forEach(c -> {
                c.setNome(c.getNome() + " Atualizado");
                clientes.save(c);
            });

            System.out.println("Buscando por nome");
            clientes.findByNome("Wilson Atualizado").forEach(System.out::println);

            System.out.println("Deletando um cliente");
            clientes.delete(arisca);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
