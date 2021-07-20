package com.mvital.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.mvital.model.dao.FilmeDaoInterface;
import com.mvital.model.model.FilmeModel;

public class FilmeServiceImplem implements FilmeServiceInterface{

	@Inject 
	private FilmeDaoInterface filmeDaoInterface;
	
	@Override
	public List<FilmeModel> getFilmes() {
		return filmeDaoInterface.getFilmes();
	}
	
	@Override
	@Transactional
	public FilmeModel salvarFilme(FilmeModel filmeModel) {
		return filmeDaoInterface.salvarFilme(filmeModel);
	}

	@Override
	@Transactional
	public void alterar(FilmeModel filmeModel) {
		filmeDaoInterface.alterar(filmeModel);
		
	}

	@Override
	@Transactional
	public void excluir(FilmeModel filmeModel) {
		filmeDaoInterface.excluir(filmeModel);
		
	}


}
