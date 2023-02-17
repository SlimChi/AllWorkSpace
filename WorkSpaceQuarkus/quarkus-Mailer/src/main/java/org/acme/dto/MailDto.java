package org.acme.dto;


import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data

public class MailDto {
    @Schema(required = true, example ="slimane.chihati@gmail.com")
    private String to;
    private String subject;
    private String text;
}
