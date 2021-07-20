package com.mvital.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mvital.model.model.FilmeModel;
import com.mvital.model.service.FilmeServiceInterface;


@Path("/filmes")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class FilmesRestFacade{
	
	@Inject
	private FilmeServiceInterface filmeServiceInterface; 
	
	@GET
	public List<FilmeModel> getFilmes() {
		return filmeServiceInterface.getFilmes();
	}
	
	@POST
	public FilmeModel salvarFilme(FilmeModel filmeModel) {
		return filmeServiceInterface.salvarFilme(filmeModel);
	}
	
	@PUT
	public void atualizar(FilmeModel filmeModel) {
		filmeServiceInterface.alterar(filmeModel);
	}
	
	@DELETE
	@Path("/{codigoFilme}")
	public void excluir(@PathParam("codigoFilme") Integer codigoFilme) {
		FilmeModel filmeModel = new FilmeModel();
		filmeModel.setCodigo(codigoFilme);
		filmeServiceInterface.excluir(filmeModel);
		
	}
}
