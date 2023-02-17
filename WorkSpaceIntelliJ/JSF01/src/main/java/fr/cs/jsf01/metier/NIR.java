package fr.cs.jsf01.metier;

public class NIR {
    private String sexe;
    private String anneeNaissance ;
    private String moisNaissance ;
    private String lieuNaissance ;
    private String ordreNaissance ;
    private String cle;


    public NIR(){
        sexe = "";
        anneeNaissance = "";
        moisNaissance = "";
        lieuNaissance = "";
        ordreNaissance = "";
        cle="";
    }

    public boolean isValid() {
        double nirNumber;
        double cleNumber;
        double modulo;

         String numberNir = sexe +anneeNaissance + moisNaissance +lieuNaissance +ordreNaissance;

             numberNir = verificationNirString(numberNir);

                nirNumber = Double.parseDouble(numberNir);
                cleNumber = Double.parseDouble(cle);
                modulo = nirNumber % 97;

                double nirFinal = 97 - modulo;

                if (nirFinal == cleNumber) {

                    return true;
                } else {
                    return false;
                }

    }
    private String verificationNirString(String numberNir) {
        numberNir = numberNir.toUpperCase();
        String compare = "";
        String newNir = numberNir;
        try {

            compare = numberNir.substring(6, 7);
            if (compare.equals("A")) {

                newNir = numberNir.replace("2A", "19");

            }
            if (compare.equals("B")) {
                newNir = numberNir.replace("2B", "18");

            }

        } catch (Exception e) {

        }

        return newNir;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


    public String getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(String anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public String getMoisNaissance() {
        return moisNaissance;
    }

    public void setMoisNaissance(String moisNaissance) {
        this.moisNaissance = moisNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getOrdreNaissance() {
        return ordreNaissance;
    }
    public void setOrdreNaissance(String ordreNaissance) {
        this.ordreNaissance = ordreNaissance;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    @Override
    public String toString() {
        return  sexe +" "+ anneeNaissance +" "+ moisNaissance +" "+ lieuNaissance +" "+ ordreNaissance +" "+ cle ;
    }
}
