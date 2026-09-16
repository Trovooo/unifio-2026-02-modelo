package br.edu.unifio.eventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.eventos.entidades.Local;
import br.edu.unifio.eventos.repository.LocalRepositorio;

@SpringBootTest 
public class LocalRepositorioTeste {

    @Autowired 
    private LocalRepositorio localRepositorio;

    @Test 
    public void deveSalvarUmNovo () {
        Local local = new Local ();
        local.setName("Adriano Salões");
        local.setEndereco("Alameda doa Alemães");
        local.setSpace(new BigDecimal(2000));

        localRepositorio.save(local);

        assertNotNull(local.getId());
        assertEquals(6, local.getId());
    }

    @Test 
    public void deveBuscarUmProduto () {
        Local local = localRepositorio.findById(Integer.parseInt("3")).orElseThrow();
        assertNotNull(local);
        assertEquals("Centro de Convenções", local.getName());
    }

    @Test 
    public void deveExcluirUmId(){
        Local local = new Local ();
        local.setName("Jorje Salão de Festas Mundial");
        local.setEndereco("Alameda dos Santos Forever");
        local.setSpace(new BigDecimal(2000));

        localRepositorio.save(local);

        assertTrue(localRepositorio.existsById(local.getId()));

        localRepositorio.deleteById(local.getId());

        localRepositorio.existsById(local.getId());
    }

    @Test 
    public void deveAtualizarONomeDoProduto (){
        Local local = new Local ();
        local.setName("Adriano Salões");
        local.setEndereco("Alameda doa Alemães");
        local.setSpace(new BigDecimal(2000));

        localRepositorio.save(local);

        local.setName("Ademar Novo Endereço");

        localRepositorio.save(local);

        
    }
}
