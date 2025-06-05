package web.dev.spring_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.dev.spring_crud.domain.dto.BillDTO;
import web.dev.spring_crud.domain.model.Bill;
import web.dev.spring_crud.domain.model.Person;
import web.dev.spring_crud.mapper.BillMapper;
import web.dev.spring_crud.repository.BillRepository;
import web.dev.spring_crud.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class BillService {

    private static BillMapper billMapper;
    private static BillRepository billRepository;
    private static PersonRepository personRepository;

    public List<BillDTO> getAllBills() {
        return billMapper.toDTOs(billRepository.findAll());
    }

    public BillDTO createBill(BillDTO billDTO) {

        Person person = personRepository.findById(billDTO.id.longValue())
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + billDTO.id));

        Bill bill = billMapper.toEntity(billDTO);

        bill.setPerson(person);
        bill.setDate(new java.util.Date());

        return billMapper.toDTO(billRepository.save(bill));
    }

    public BillDTO deleteBill(Integer billId) {

        Bill bill = billRepository.findById(billId.longValue())
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + billId));

        billRepository.deleteById(billId.longValue());

        return billMapper.toDTO(bill);
    }

}
