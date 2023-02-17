package fr.cs.sdbmhibernateapi.endpoint;

import fr.cs.sdbmhibernateapi.dto.PaysDto;
import fr.cs.sdbmhibernateapi.entities.CouleurEntity;
import fr.cs.sdbmhibernateapi.entities.PaysEntity;
import fr.cs.sdbmhibernateapi.repositories.CouleurRepository;
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
@Tag(name = "pays")
@Produces(MediaType.APPLICATION_JSON)
@Path("/pays")
public class PaysResource {

    PaysRepository paysRepository = new PaysRepository();

    @GET
    @Operation(summary = "Récupère la liste des pays.")
    @ApiResponse(responseCode = "200", description = "La requête s'est bien effectué.")
    public Response getAll() {
        List<PaysDto> pays = paysRepository.getAll();
        return Response.ok(pays).build();
    }
}
