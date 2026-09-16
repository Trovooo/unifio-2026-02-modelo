package br.edu.unifio.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.eventos.entidades.Categoria;



public interface CategoriaRepositorio extends JpaRepository <Categoria, Integer> {

}
