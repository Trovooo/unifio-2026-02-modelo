package br.edu.unifio.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.eventos.entidades.Evento;

public interface EventoRepositorio extends JpaRepository<Evento, Integer> {

}
