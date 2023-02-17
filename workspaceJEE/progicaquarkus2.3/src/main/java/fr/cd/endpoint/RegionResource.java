package fr.cd.endpoint;


import fr.cd.dto.DepartementDto;
import fr.cd.entities.DepartementEntity;
import fr.cd.entities.RegionEntity;
import fr.cd.repositories.DepartementRepository;
import fr.cd.repositories.RegionRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Regions")
@Path("/Regions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegionResource {

    @Inject
    RegionRepository regionRepository;

    @Inject
    DepartementRepository departementRepository;

    @GET
    @Operation(summary = "Liste des regions")
    public Response getAll(){
        List<RegionEntity> regions = regionRepository.listAll();
        return Response.ok(regions).build();

    }
    @GET
    @Path("{id}")
    public Response getbyId(@PathParam("id") Integer id){
        RegionEntity region = regionRepository.findById(id);
        return Response.ok(region).build();

    }

    @GET
    @Path("{id}/departements")
    public Response getDepartementsByIdRegion(@PathParam("id")Integer id){

        List<DepartementDto> departementDto = DepartementDto.toDepartementDtoList((List<DepartementEntity>) departementRepository.find("id_region",id));

        return Response.ok(departementDto).build();
    }
}
