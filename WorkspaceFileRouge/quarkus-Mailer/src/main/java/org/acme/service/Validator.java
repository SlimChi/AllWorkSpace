package org.acme.service;

import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidMail(String email) {

        String pattern = String.format("\"^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*\"\n"+"+[A-Za-z0-9_-]+[A-Za-z0-9-] \"@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$\"");

        return Pattern.compile(pattern).matcher(email).matches();
    }
}
