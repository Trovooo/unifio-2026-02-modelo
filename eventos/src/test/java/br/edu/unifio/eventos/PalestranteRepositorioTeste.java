package br.edu.unifio.eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.eventos.entidades.Palestrante;
import br.edu.unifio.eventos.repository.PalestranteRepositorio;

@SpringBootTest 
public class PalestranteRepositorioTeste {

    @Autowired 
    private PalestranteRepositorio palestranteRepositorio;

    @Test 
    public void deveSalvarUmNovo () {
        var palestrante = new Palestrante();
        palestrante.setName("Ademir");
        palestrante.setEmail("ademirvaulicio@gmail.com");
        palestrante.setMiniBio("Sou fisioterapeutazin");

        palestranteRepositorio.save(palestrante);

        assertNotNull(palestrante.getId());
        assertEquals(6, palestrante.getId());
    }

    @Test
    public void deveBuscarUmProduto () {
        var palestrante = palestranteRepositorio.findById(Integer.parseInt("3")).orElseThrow();
        assertNotNull(palestrante);
        assertEquals("Carlos Eduardo", palestrante.getName());
    }

    @Test 
    public void deveBuscarTodosOsProdutos () {
        List<Palestrante> palestrante = palestranteRepositorio.findAll(Sort.by("name"));
        assertEquals(5, palestrante.size());
        assertEquals("Beatriz Lima", palestrante.get(0).getName());
    }

    @Test 
    public void deveExcluirUmId () {
        var palestrante = new Palestrante();
        palestrante.setName("Ademir");
        palestrante.setEmail("ademirvaulicio@gmail.com");
        palestrante.setMiniBio("Sou fisioterapeutazin");

        palestranteRepositorio.save(palestrante);
        assertTrue(palestranteRepositorio.existsById(palestrante.getId()));
        palestranteRepositorio.deleteById(palestrante.getId());
        palestranteRepositorio.existsById(palestrante.getId());

    }

    @Test 
    public void  deveAtualizarONomeDoProduto () {
        var palestrante = new Palestrante();
        palestrante.setName("Ademir");
        palestrante.setEmail("ademirvaulicio@gmail.com");
        palestrante.setMiniBio("Sou fisioterapeutazin");

        palestranteRepositorio.save(palestrante);

        palestrante.setName("Aldemir Safadinho");

        palestranteRepositorio.save(palestrante);

        assertEquals("Aldemir Safadinho", palestranteRepositorio.findById(palestrante.getId()). orElseThrow().getName());
    }
}
