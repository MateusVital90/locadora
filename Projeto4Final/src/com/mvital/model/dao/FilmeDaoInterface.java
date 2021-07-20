package com.mvital.model.dao;

import java.util.List;

import com.mvital.model.model.FilmeModel;

public interface FilmeDaoInterface {
	
  FilmeModel salvarFilme(FilmeModel filmeModel);
  
  void alterar(FilmeModel filmeModel);
  
  void excluir(FilmeModel filmeModel);
  
  List<FilmeModel> getFilmes();
  
}
