package br.edu.unifio.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.eventos.entidades.Participante;

public interface ParticipanteRepositorio extends JpaRepository <Participante, Integer>{

}
