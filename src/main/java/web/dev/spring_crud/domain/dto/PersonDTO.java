package web.dev.spring_crud.domain.dto;

import java.util.Set;

public class PersonDTO {

    public Integer id;
    public String name;
    public String email;
    public Set<BillDTO> bills;

}
