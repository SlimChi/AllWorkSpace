package fr.cs.sdbmhibernateapi.dto;

import fr.cs.sdbmhibernateapi.entities.ContinentEntity;
import fr.cs.sdbmhibernateapi.entities.PaysEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaysDto {
    private int id;
    private String nom;
    private Continent continent;

    public PaysDto(PaysEntity paysEntity){
        id = paysEntity.getIdPays();
        nom = paysEntity.getNomPays();
        continent = new Continent(paysEntity.getContinent());
    }

    public static List<PaysDto> toPaysDtoList(List<PaysEntity> paysEntities) {

        List<PaysDto> paysDtoList = new ArrayList<>();
        for (PaysEntity paysEntity : paysEntities) {
            paysDtoList.add(new PaysDto(paysEntity));
        }

        return paysDtoList;
    }
    @Getter
    @Setter
    private class Continent{
        private int id;
        private String nom;

        public Continent(ContinentEntity continentEntity) {
            id = continentEntity.getIdContinent();
            nom = continentEntity.getNomContinent();
        }
    }

}
