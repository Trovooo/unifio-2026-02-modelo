package br.edu.unifio.eventos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.eventos.entidades.Categoria;
import br.edu.unifio.eventos.repository.CategoriaRepositorio;

@SpringBootTest
public class CategoriaRepositorioTeste {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void deveSalvarUmaNovaCategoria () {
        Categoria categoria
    }
}
