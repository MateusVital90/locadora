package com.mvital.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.mvital.model.dao.GeneroDaoInterface;
import com.mvital.model.model.GeneroModel;

public class GeneroServiceImplem implements GeneroServiceInterface{

	@Inject 
	private GeneroDaoInterface generoDaoInterface;
	
	@Override
	public List<GeneroModel> getGeneros() {
		return generoDaoInterface.getGeneros();
	}
	
	@Override
	@Transactional
	public GeneroModel salvarGenero(GeneroModel generoModel) {
		return generoDaoInterface.salvarGenero(generoModel);
	}

	@Override
	@Transactional
	public void alterar(GeneroModel generoModel) {
		generoDaoInterface.alterar(generoModel);
		
	}

	@Override
	@Transactional
	public void excluir(GeneroModel generoModel) {
		generoDaoInterface.excluir(generoModel);
		
	}


}
