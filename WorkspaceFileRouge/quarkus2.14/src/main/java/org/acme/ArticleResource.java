package org.acme;

import org.acme.entities.ArticleEntity;
import org.acme.repositories.ArticleRespository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Tag(name="articles")
@Produces(MediaType.APPLICATION_JSON)
@Path("/articles")
public class ArticleResource {
    @Inject
    ArticleRespository articleRespository;
    @Operation(summary = "Récupère la liste des artciles.")
    @GET
    public Response getAll() {
        List<ArticleEntity> articles = articleRespository.listAll();
        return Response.ok(articles).build();
    }

    @Operation(summary = "Récupère un article selon son ID.")
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Integer id) {
        ArticleEntity articles = articleRespository.findById(id);
        return Response.ok(articles).build();
    }


}
