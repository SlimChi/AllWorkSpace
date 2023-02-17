package org.acme;

import org.acme.entities.CouleurEntity;
import org.acme.repositories.CouleurRepository;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/couleurs")
@Tag(name = "Couleurs")
@Produces(MediaType.APPLICATION_JSON)
public class CouleurResource {
    @Inject
    CouleurRepository couleurRepository;
    @GET
    public Response getAll() {
        List<CouleurEntity> couleurs = couleurRepository.listAll();
        return Response.ok(couleurs).build();
    }
}
