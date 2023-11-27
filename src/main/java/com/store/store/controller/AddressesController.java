package com.store.store.controller;

import com.store.store.business.abstracts.AddressService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.address.CreateAddressRequest;
import com.store.store.dto.requests.address.DeleteAddressRequest;
import com.store.store.dto.requests.address.UpdateAddressRequest;
import com.store.store.dto.responses.address.GetAllAddressResponses;
import com.store.store.dto.responses.address.GetByIdAddressResponse;
import com.store.store.model.Address;
import com.store.store.repository.AddressRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/v1/address")
@RestController
public class AddressesController {

    private AddressService addressService;
    private AddressRepository addressRepository;

    @GetMapping("/getall")
    public DataResult<List<GetAllAddressResponses>> getAll() {
        return this.addressService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdAddressResponse> getById(int id) {
        return this.addressService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateAddressRequest createAddressRequest) {
        return this.addressService.add(createAddressRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateAddressRequest updateAddressRequest) {
        return this.addressService.update(updateAddressRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteAddressRequest deleteAddressRequest) {
        return this.addressService.delete(deleteAddressRequest);
    }
}
