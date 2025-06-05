package web.dev.spring_crud.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import web.dev.spring_crud.domain.dto.BillDTO;
import web.dev.spring_crud.domain.model.Bill;

@Mapper(componentModel = ComponentModel.SPRING)
public interface BillMapper {

    // map dto to entity
    Bill toEntity(BillDTO billDTO);

    // map entity to dto
    BillDTO toDTO(Bill bill);

    // map set of dto to set of entity
    List<Bill> toEntities(List<BillDTO> billDTOs);

    // map set of entity to set of dto
    List<BillDTO> toDTOs(List<Bill> bills);

}