package org.acme;

import org.acme.entities.CouleurEntity;
import org.acme.repositories.CouleurRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/couleurs")
@Tag(name="Couleurs")
@Produces(MediaType.APPLICATION_JSON)
public class CouleurResource {

    @Inject
    CouleurRepository couleurRepository;

    @GET
    public Response getAll() {
        List<CouleurEntity> couleurs = couleurRepository.listAll();
        return Response.ok(couleurs).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insert(CouleurEntity couleur) {

        if (couleur == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        couleurRepository.persist(couleur);
        return Response.ok(couleur).status(Response.Status.CREATED).build();

    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Integer id) {

        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        CouleurEntity couleur = new CouleurEntity();
        couleur.setId(id);
        couleurRepository.deleteById(id);
            return Response.status(204).build();

    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response update(@PathParam("id") Integer idType, CouleurEntity couleur){
        CouleurEntity couleurEntity = couleurRepository.findById(idType);

        couleurEntity.setNom(couleur.getNom());
        return Response.ok(couleurEntity).build();
    }
}