package com.example.lab6_micro.api;

import com.example.lab6_micro.model.Compte;
import com.example.lab6_micro.repository.CompteRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CompteRestJaxRSAPI {
	private final CompteRepository compteRepository;

	public CompteRestJaxRSAPI(CompteRepository compteRepository) {
		this.compteRepository = compteRepository;
	}

	@Path("/comptes")
	@GET
	public List<Compte> getComptes() {
		return compteRepository.findAll();
	}

	@Path("/comptes/{id}")
	@GET
	public Response getCompte(@PathParam("id") Long id) {
		return compteRepository.findById(id)
				.<Response>map(compte -> Response.ok(compte).build())
				.orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
	}

	@Path("/comptes")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addCompte(Compte compte) {
		Compte saved = compteRepository.save(compte);
		return Response.status(Response.Status.CREATED).entity(saved).build();
	}

	@Path("/comptes/{id}")
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateCompte(@PathParam("id") Long id, Compte compte) {
		return compteRepository.findById(id)
				.map(existing -> {
					existing.setSolde(compte.getSolde());
					existing.setDateCreation(compte.getDateCreation());
					existing.setType(compte.getType());
					return Response.ok(compteRepository.save(existing)).build();
				})
				.orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
	}

	@Path("/comptes/{id}")
	@DELETE
	public Response deleteCompte(@PathParam("id") Long id) {
		if (!compteRepository.existsById(id)) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		compteRepository.deleteById(id);
		return Response.noContent().build();
	}
}
