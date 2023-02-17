package fr.cs.mailapi.endpoint;


import fr.cs.mailapi.metier.InfoEmail;
import fr.cs.mailapi.security.Email;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/mail")
public class MailResource {
    @POST
    @ApiResponse(responseCode = "400", description = "La syntaxe ou le contenu est invalide.")
    @ApiResponse(responseCode = "401", description = "Vous n'avez pas l'autorisation.")
    @ApiResponse(responseCode = "500", description = "Erreur serveur, veuillez réessayer plus tard.")
    public Response sendMail(@HeaderParam("apikey") String apiKey, InfoEmail infoEmail) {


        if (infoEmail == null || apiKey == null) {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if ( !apiKey.equals("XXX-ABC") ) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        if (!Email.verifMail(infoEmail.getDestinataire())) {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(Email.sendEmail(infoEmail))
            return Response.status(Response.Status.ACCEPTED).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @GET
    public Response generateApiKey() {

        return Response.ok("XXX-ABC").build();
    }

}
