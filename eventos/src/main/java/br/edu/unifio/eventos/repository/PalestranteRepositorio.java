package br.edu.unifio.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.eventos.entidades.Palestrante;

public interface PalestranteRepositorio extends JpaRepository <Palestrante, Integer>{

}
