package fr.cs.sdbmhibernateapi.endpoint;

import fr.cs.sdbmhibernateapi.entities.CouleurEntity;
import fr.cs.sdbmhibernateapi.repositories.CouleurRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Tag(name = "couleurs")
@Produces(MediaType.APPLICATION_JSON)
@Path("/couleurs")
public class CouleurResource {


    CouleurRepository couleurRepository = new CouleurRepository();


    @GET
    @Operation(summary = "Récupère la liste des couleurs.")
    @ApiResponse(responseCode = "200", description = "La requête s'est bien effectué.")
    public Response getAll() {
        List<CouleurEntity> couleurs = couleurRepository.getAll();
        return Response.ok(couleurs).build();
    }

    @GET
    @Operation(summary = "Récupère la couleur selon son ID.")
    @ApiResponse(responseCode = "200", description = "La requête s'est bien effectué.")
    @ApiResponse(responseCode = "404", description = "La couleur n'as pas été trouvé.")
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        CouleurEntity couleur = couleurRepository.getById(id);

        if (couleur.getNomCouleur() == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else
            return Response.ok(couleur).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponse(responseCode = "200", description = "Réussite de la création de couleur.")
    @ApiResponse(responseCode = "401", description = "Vous n'avez pas l'autorisation.")
    public Response insert(CouleurEntity couleur) {

        if (couleur == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        couleurRepository.create(couleur);
        return Response.ok(couleur).status(Response.Status.CREATED).build();

    }



    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponse(responseCode = "400", description = "Non trouvé.")
    @ApiResponse(responseCode = "401", description = "Vous n'avez pas l'autorisation.")
    @ApiResponse(responseCode = "204", description = "Supprimé.")
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {

        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        CouleurEntity couleur = new CouleurEntity();
        couleur.setIdCouleur(id);
        if (couleurRepository.delete(couleur))
            return Response.status(204).build();
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
}
