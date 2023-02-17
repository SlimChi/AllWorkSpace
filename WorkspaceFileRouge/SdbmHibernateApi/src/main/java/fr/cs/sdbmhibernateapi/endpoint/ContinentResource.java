package fr.cs.sdbmhibernateapi.endpoint;

import fr.cs.sdbmhibernateapi.dto.ContinentDto;
import fr.cs.sdbmhibernateapi.entities.ContinentEntity;
import fr.cs.sdbmhibernateapi.entities.PaysEntity;
import fr.cs.sdbmhibernateapi.repositories.ContinentRepository;
import fr.cs.sdbmhibernateapi.repositories.PaysRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Tag(name = "continents")
@Produces(MediaType.APPLICATION_JSON)
@Path("/continents")
public class ContinentResource {

    ContinentRepository continentRepository = new ContinentRepository();

    @GET
    @Operation(summary = "Récupère la liste des continents.")
    @ApiResponse(responseCode = "200", description = "La requête s'est bien effectué.")
    public Response getAll() {
        List<ContinentDto> continents = continentRepository.getAll();
        return Response.ok(continents).build();
    }
}
