package br.edu.unifio.eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.eventos.entidades.Categoria;
import br.edu.unifio.eventos.repository.CategoriaRepositorio;

@SpringBootTest
public class CategoriaRepositorioTeste {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void deveSalvarUmaNovaCategoria () {
        var categoria = new Categoria();
        categoria.setName("Cigarro Eletronico");
        categoria.setDescription("Serve para adolecentes");

        categoriaRepositorio.save(categoria);

        assertNotNull(categoria.getId());
        assertEquals(6, categoria.getId());
    }

    @Test 
    public void deveBuscarUmProdutoPorId () {
        Categoria categoria = categoriaRepositorio.findById(Integer.parseInt("3")).orElseThrow();
        assertNotNull(categoria);
        assertEquals("Negócios", categoria.getName());
    }

    @Test
    public void deveBuscarTodosOsProdutos () {
        List<Categoria> categoria = categoriaRepositorio.findAll(Sort.by("name"));
        assertEquals(5, categoria.size());
        assertEquals("Carreira", categoria.get(0).getName());
        assertEquals("Design", categoria.get(1).getName());
    }

    @Test
    public void deveExcluirUmProdutoPorId () {
        var categoria = new Categoria();
        categoria.setName("Cigarro Normal");
        categoria.setDescription("Serve para todas as idades");
        

        Categoria Categoria  = categoriaRepositorio.findById(1).orElseThrow();
        

        categoriaRepositorio.save(Categoria);

        assertTrue(categoriaRepositorio.existsById(Categoria.getId()));

        categoriaRepositorio.deleteById(Categoria.getId());
    }

    @Test 
    public void deveAtualizarONomeDeUmProduto () {
        var categoria = new Categoria();
        categoria.setName("Cigarro Normal");
        categoria.setDescription("Serve para todas as idades");
        

        categoria.setName("Nome Pro Teste Supremo");

        categoriaRepositorio.save(categoria);

        assertEquals("Cigarro Normal", categoriaRepositorio.findById(categoria.getId()).orElseThrow().getName());
    }
}
