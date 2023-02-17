package fr.cs.mailapi.metier;

public class InfoEmail {
    private String subject;
    private String destinataire;
    private String body;

    public InfoEmail(){
    }

    public InfoEmail(String destinataire,String subject, String body) {
        this.destinataire = destinataire;
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String expediteur) {
        this.subject = expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
