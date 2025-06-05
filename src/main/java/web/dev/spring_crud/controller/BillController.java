package web.dev.spring_crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import web.dev.spring_crud.domain.dto.BillDTO;
import web.dev.spring_crud.service.BillService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllBills() {
        return ResponseEntity.ok().body(billService.getAllBills());
    }

    @GetMapping("/byPersonId/{personId}")
    public ResponseEntity<?> getBillsByPersonId(@PathVariable Long personId) {
        return ResponseEntity.ok().body(billService.getBillsByPersonId(personId));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBill(@RequestBody BillDTO billDTO) {
        return ResponseEntity.ok().body(billService.createBill(billDTO));
    }

    @DeleteMapping("/deleteById/{billId}")
    public ResponseEntity<?> deleteBill(@PathVariable Integer billId) {
        return ResponseEntity.ok().body(billService.deleteBill(billId));
    }

}
