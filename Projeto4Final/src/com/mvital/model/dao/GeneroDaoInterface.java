package com.mvital.model.dao;

import java.util.List;

import com.mvital.model.model.GeneroModel;

public interface GeneroDaoInterface {
	
  GeneroModel salvarGenero(GeneroModel generoModel);
  
  void alterar(GeneroModel generoModel);
  
  void excluir(GeneroModel generoModel);
  
  List<GeneroModel> getGeneros();
  
}
