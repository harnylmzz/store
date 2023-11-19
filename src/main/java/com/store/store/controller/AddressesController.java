package com.store.store.controller;

import com.store.store.business.abstracts.AddressService;
import com.store.store.core.result.DataResult;
import com.store.store.dto.responses.address.GetAllAddressResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/v1/address")
@RestController
public class AddressesController {

    private AddressService addressService;

    @GetMapping("/getall")
    public DataResult<List<GetAllAddressResponses>> getAll() {
        return this.addressService.getAll();
    }
}
