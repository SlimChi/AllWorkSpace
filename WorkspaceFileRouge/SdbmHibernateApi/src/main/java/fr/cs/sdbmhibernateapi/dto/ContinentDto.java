package fr.cs.sdbmhibernateapi.dto;

import fr.cs.sdbmhibernateapi.entities.ContinentEntity;
import fr.cs.sdbmhibernateapi.entities.PaysEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContinentDto {

    private int id;
    private String nom;
    private List<Pays> countries;

    public ContinentDto(ContinentEntity continentEntity){
        id = continentEntity.getIdContinent();
        nom = continentEntity.getNomContinent();
        countries = fromPaysDtoList(continentEntity.getCountries());
    }

    private List<Pays> fromPaysDtoList(List<PaysEntity> paysEntities) {
        List<Pays> paysList = new ArrayList<Pays>();
        for (PaysEntity paysEntity : paysEntities){
            paysList.add(new Pays(paysEntity));
        }
        return paysList;
    }

    public static List<ContinentDto> toContinentDtoList(List<ContinentEntity> continentEntities){
        List<ContinentDto> continentDtoList = new ArrayList<>();
        for (ContinentEntity continentEntity : continentEntities){
            continentDtoList.add(new ContinentDto(continentEntity));
        }
        return continentDtoList;
    }
    @Getter
    @Setter
    class Pays{
        private int id;
        private String nom;

        public Pays(PaysEntity paysEntity){
            id= paysEntity.getIdPays();
            nom = paysEntity.getNomPays();
        }
    }
}
