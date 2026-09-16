package br.edu.unifio.eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.eventos.entidades.Inscricao;
import br.edu.unifio.eventos.repository.InscricaoRepositorio;

@SpringBootTest 
public class InscricaoRepositorioTeste {

    @Autowired 
    private InscricaoRepositorio inscricaoRepositorio;

    @Test 
    public void deveSalvarUmNovoProduto ()  {
        Inscricao inscricao  = new Inscricao ();
        inscricao.setDataInscricao(LocalDate.of(2026, 05, 12));
        inscricao.setStatus("ATIVO");

        inscricaoRepositorio.save(inscricao);

        assertNotNull(inscricao.getId());
        assertEquals(6, inscricao.getId());
    }

    @Test
    public void deveBuscarUmProdutoPorId () {
        Inscricao inscricao = inscricaoRepositorio.findById(Integer.parseInt("3")).orElseThrow();
        assertNotNull(inscricao);
        assertEquals(LocalDate.of(2026, 9, 03), inscricao.getDataInscricao());
    }

    @Test
    public void deveExcluirUmNovoId () {
        Inscricao inscricao  = new Inscricao ();
        inscricao.setDataInscricao(LocalDate.of(2022, 04, 19));
        inscricao.setStatus("ATIVO");

        inscricaoRepositorio.save(inscricao);

        assertTrue(inscricaoRepositorio.existsById(inscricao.getId()));

        inscricaoRepositorio.deleteById(inscricao.getId());

        inscricaoRepositorio.existsById(inscricao.getId());
    }

    @Test 
    public void deveAtualizarONomeDoProduto () {
        Inscricao inscricao  = new Inscricao ();
        inscricao.setDataInscricao(LocalDate.of(2026, 10, 8));
        inscricao.setStatus("ATIVO");

        inscricaoRepositorio.save(inscricao);

        inscricao.setDataInscricao(LocalDate.of(2026, 10, 20));

        inscricaoRepositorio.save(inscricao);

        assertEquals(LocalDate.of(2026, 10, 20), inscricaoRepositorio.findById(inscricao.getId()).orElseThrow().getDataInscricao());
    }
}
