package com.mvital.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mvital.model.model.GeneroModel;

public class GeneroDaoImplem implements GeneroDaoInterface{

	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public GeneroModel salvarGenero(GeneroModel generoModel) {
		entityManager.persist(generoModel);
		return generoModel;
	}

	@Override
	public void alterar(GeneroModel generoModel) {
		GeneroModel generoModelMerge = entityManager.merge(generoModel);
		entityManager.persist(generoModelMerge);
		
	}

	@Override
	public void excluir(GeneroModel generoModel) {
		GeneroModel generoModelMerge = entityManager.merge(generoModel);
		entityManager.remove(generoModelMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<GeneroModel> getGeneros() {
	    Query query = entityManager.createQuery("from GeneroModel");
	    return query.getResultList();
	}

}
