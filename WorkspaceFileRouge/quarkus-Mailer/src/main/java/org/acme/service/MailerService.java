package org.acme.service;


import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.acme.dto.MailDto;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mailer")
public class MailerService {

    @Inject
    Mailer mailer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response sendEmail(MailDto mail){

        mailer.send(
                Mail.withText(mail.getTo(),
                              mail.getSubject(),
                              mail.getText())
        );
        return Response.ok(String.format(mail.getSubject(), mail.getTo())).build();
    }
}
