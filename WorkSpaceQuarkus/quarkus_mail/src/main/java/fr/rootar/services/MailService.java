package fr.rootar.services;


import fr.rootar.dto.MailDto;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/mail")
public class MailService {

    @Inject
    Mailer mailer;


@POST
@HeaderParam("{ApiKey}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public Response sendEmail(MailDto mail,@HeaderParam("Apikey") String apiKey) {
        /*if(!Validator.isValidMail(mail.getTo()))
        return Response.ok("Adresse mail non valide").status(400).build();*/
        if (!apiKey.equals("ItsOKForYou")) {
        return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        else{
        mailer.send(
        Mail.withText(mail.getTo(),
        mail.getSubject(),
        mail.getText())
        );
        return Response.ok(mailer).build();
        }

        }

}
