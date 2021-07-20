package com.mvital.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mvital.model.model.FilmeModel;

public class FilmeDaoImplem implements FilmeDaoInterface{

	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public FilmeModel salvarFilme(FilmeModel filmeModel) {
		entityManager.persist(filmeModel);
		return filmeModel;
	}

	@Override
	public void alterar(FilmeModel filmeModel) {
		FilmeModel filmeModelMerge = entityManager.merge(filmeModel);
		entityManager.persist(filmeModelMerge);
		
	}

	@Override
	public void excluir(FilmeModel filmeModel) {
		FilmeModel filmeModelMerge = entityManager.merge(filmeModel);
		entityManager.remove(filmeModelMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FilmeModel> getFilmes() {
	    Query query = entityManager.createQuery("from FilmeModel");
	    return query.getResultList();
	}

}
