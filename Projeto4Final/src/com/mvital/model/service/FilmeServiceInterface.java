package com.mvital.model.service;

import java.util.List;

import com.mvital.model.model.FilmeModel;

public interface FilmeServiceInterface {
	 FilmeModel salvarFilme(FilmeModel filmeModel);
	  
	  void alterar(FilmeModel filmeModel);
	  
	  void excluir(FilmeModel filmeModel);
	  
	  List<FilmeModel> getFilmes();

}
