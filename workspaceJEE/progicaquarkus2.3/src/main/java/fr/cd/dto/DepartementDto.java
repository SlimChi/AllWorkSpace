package fr.cd.dto;

import fr.cd.entities.DepartementEntity;
import fr.cd.entities.VilleEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartementDto {

    private String codeInseeDept;
    private String nomDept;
    private int idRegion;


    public DepartementDto(DepartementEntity departementEntity){
        codeInseeDept = departementEntity.getCodeInseeDept();
        nomDept = departementEntity.getNomDepartement();
        idRegion = departementEntity.getIdRegion();
    }



    public static List<DepartementDto> toDepartementDtoList(List<DepartementEntity> departementEntities) {
        List<DepartementDto> departementDtoList = new ArrayList<>();
        for (DepartementEntity departementEntity : departementEntities) {
            departementDtoList.add(new DepartementDto(departementEntity));
        }
        return departementDtoList;
    }

}
