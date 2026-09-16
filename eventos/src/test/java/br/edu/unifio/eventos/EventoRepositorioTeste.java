package br.edu.unifio.eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.eventos.entidades.Evento;
import br.edu.unifio.eventos.repository.EventoRepositorio;


@SpringBootTest 

public class EventoRepositorioTeste {
    @Autowired 
    private EventoRepositorio eventoRepositorio;



    @Test 
    public void deveSalvarUmNovoProduto () {
        Evento evento  = new Evento();
        evento.setNome("Adilson");
        evento.setDescricao("Palestrante de Direito");
        evento.setDataInicio(LocalDate.of(2026, 05, 10));
        evento.setDataFim(LocalDate.of(2026, 05, 20));
        evento.setCapacidade(1500);
        evento.setStatus("ATIVO");

        eventoRepositorio.save(evento);

        assertNotNull(evento.getId());
        assertEquals(6, evento.getId());
    }

    @Test 
    public void deveBuscarUmProdutoPorId () {
        Evento evento = eventoRepositorio.findById(Integer.parseInt("3")).orElseThrow();
        assertNotNull(evento);
        assertEquals("Semana da Engenharia de Software", evento.getNome());
    }

    @Test
    public void deveBuscarTodosOsProdutos () {
        List<Evento> evento = eventoRepositorio.findAll(Sort.by("nome"));
        assertEquals(5, evento.size());
        assertEquals("Game Dev Summit", evento.get(0).getNome());
    }

    @Test 
    public void deveExcluirUmProdutoPorId  () {
        Evento evento  = new Evento();
        evento.setNome("Aldemar");
        evento.setDescricao("Palestrante de Direito");
        evento.setDataInicio(LocalDate.of(2026, 05, 25));
        evento.setDataFim(LocalDate.of(2026, 05, 31));
        evento.setCapacidade(4000);
        evento.setStatus("ATIVO");


        eventoRepositorio.save(evento);

        assertTrue(eventoRepositorio.existsById(evento.getId()));

        eventoRepositorio.deleteById(evento.getId());
        eventoRepositorio.existsById(evento.getId());
    }

    @Test 
    public void deveAtualizarONomeDeUmProduto () {
        Evento evento  = new Evento();
        evento.setNome("Aldemarzinho");
        evento.setDescricao("Palestrante de Direitinho");
        evento.setDataInicio(LocalDate.of(2026, 05, 25));
        evento.setDataFim(LocalDate.of(2026, 05, 31));
        evento.setCapacidade(4000);
        evento.setStatus("ATIVO");

        eventoRepositorio.save(evento);

        evento.setNome("Aldemar Novo Nome Nascimento");

        eventoRepositorio.save(evento);

        assertEquals("Aldemar Novo Nome Nascimento", eventoRepositorio.findById(evento.getId()).orElseThrow().getNome());
    }

}
