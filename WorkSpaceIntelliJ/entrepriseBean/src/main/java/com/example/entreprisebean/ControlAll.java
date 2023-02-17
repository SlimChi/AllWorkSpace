package com.example.entreprisebean;

import java.util.regex.Pattern;

public class ControlAll {


    public ControlAll() {

    }

    public static boolean verifSiren(String siren) {
        return Pattern.matches("^[0-9]{9}$", siren) && sirenIsValid(siren);
    }

    private static boolean sirenIsValid(String siren) {
        int somme = calculSiren(siren);
        if (somme % 10 == 0)
            return true;
        else return false;
    }


    private static int calculSiren(String siren) {
        int total = 0;
        int multi = 0;
        for (int i = 0; i < siren.length(); i++) {
            multi = Integer.parseInt(String.valueOf(siren.charAt(i))) * 2;
            if (i % 2 == 1)
                total = total + (multi / 10) + (multi % 10);
            else total = total + Integer.parseInt(String.valueOf(siren.charAt(i)));
            // System.out.println(total);
        }
        return total;

    }

    public static boolean verifierCodePostal(String codePostal) {
        return Pattern.matches("^(0[1-9]|[13-9][0-9]|2[AaBb1-9])([0-9]{3})$", codePostal);
    }


    public static boolean verifierRegexAdresse(String adresse) {
        return Pattern.matches("^[a-zA-Z0-9,. -]{5,38}$", adresse);
    }

    public static boolean verifierRsocial(String rSocial) {
        return Pattern.matches("^[a-zA-Z0-9,. -]{3,38}$", rSocial);
    }

}
