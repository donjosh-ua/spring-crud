package web.dev.spring_crud.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.MappingConstants.ComponentModel;

import web.dev.spring_crud.domain.dto.BillDTO;
import web.dev.spring_crud.domain.model.Bill;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BillMapper {

    // map dto to entity
    @Mapping(target = "person.id", source = "personId")
    Bill toEntity(BillDTO billDTO);

    // map entity to dto
    @Mapping(target = "personId", source = "person.id")
    BillDTO toDTO(Bill bill);

    // map set of dto to set of entity
    List<Bill> toEntities(List<BillDTO> billDTOs);

    // map set of entity to set of dto
    List<BillDTO> toDTOs(List<Bill> bills);

}