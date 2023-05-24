package com.csidigital.finance.management.controller;

import com.csidigital.finance.management.service.BillClientService;
import com.csidigital.finance.shared.dto.Request.BillClientDtoRequest;
import com.csidigital.finance.shared.dto.Response.BillClientDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/fm/billClients")
@CrossOrigin("*")
public class BillClientController {

    private final BillClientService billClientService;
    @Autowired
    public BillClientController(BillClientService billClientService, ModelMapper modelMapper) {
        this.billClientService = billClientService;
    }


    @GetMapping()
    public List<BillClientDtoResponse> getAllBillClients() {
        return billClientService.getAllBillClients();
    }

    @GetMapping("/{id}")
    public BillClientDtoResponse getBillClientById(@PathVariable Long id){
        return billClientService.getBillClientById(id);
    }

    @PostMapping()
    public BillClientDtoResponse createBillClient( @RequestBody BillClientDtoRequest billClientDtoRequest){
        return billClientService.CreateBillClient(billClientDtoRequest);
    }

    @PutMapping("/{id}")
    public BillClientDtoResponse updateBillClient( @RequestBody  BillClientDtoRequest billClientDtoRequest, @PathVariable Long id){
        return billClientService.updateBillClient(billClientDtoRequest, id);
    }


    @DeleteMapping("/{id}")
    public void deleteBillClient(@PathVariable Long id){
        billClientService.deleteBillClientById(id);
    }


}
