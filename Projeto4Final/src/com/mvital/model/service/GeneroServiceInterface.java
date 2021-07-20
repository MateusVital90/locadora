package com.mvital.model.service;

import java.util.List;

import com.mvital.model.model.GeneroModel;

public interface GeneroServiceInterface {
	 GeneroModel salvarGenero(GeneroModel generoModel);
	  
	  void alterar(GeneroModel generoModel);
	  
	  void excluir(GeneroModel generoModel);
	  
	  List<GeneroModel> getGeneros();

}
