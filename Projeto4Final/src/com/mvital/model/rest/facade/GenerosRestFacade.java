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

import com.mvital.model.model.GeneroModel;
import com.mvital.model.service.GeneroServiceInterface;


@Path("/generos")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class GenerosRestFacade{
	
	@Inject
	private GeneroServiceInterface generoServiceInterface; 
	
	@GET
	public List<GeneroModel> getGeneros() {
		return generoServiceInterface.getGeneros();
	}
	
	@POST
	public GeneroModel salvarGenero(GeneroModel generoModel) {
		return generoServiceInterface.salvarGenero(generoModel);
	}
	
	@PUT
	public void atualizar(GeneroModel generoModel) {
		generoServiceInterface.alterar(generoModel);
	}
	
	@DELETE
	@Path("/{codigoGenero}")
	public void excluir(@PathParam("codigoGenero") Integer codigoGenero) {
		GeneroModel generoModel = new GeneroModel();
		generoModel.setCodigo(codigoGenero);
		generoServiceInterface.excluir(generoModel);
		
	}
}
