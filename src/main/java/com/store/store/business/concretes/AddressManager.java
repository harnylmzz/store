package com.store.store.business.concretes;

import com.store.store.business.abstracts.AddressService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.business.dto.requests.address.CreateAddressRequest;
import com.store.store.business.dto.requests.address.DeleteAddressRequest;
import com.store.store.business.dto.requests.address.UpdateAddressRequest;
import com.store.store.business.dto.responses.address.GetAllAddressResponses;
import com.store.store.business.dto.responses.address.GetByIdAddressResponse;
import com.store.store.model.Address;
import com.store.store.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllAddressResponses>> getAll() {

        List<Address> addresses = addressRepository.findAll();
        List<GetAllAddressResponses> getAllAddressResponses = addresses.stream()
                .map(address -> this.modelMapperService.forResponse()
                        .map(address, GetAllAddressResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllAddressResponses, true, "All addresses listed.");
    }

    @Override
    public DataResult<GetByIdAddressResponse> getById(int id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Address not found."));

        GetByIdAddressResponse getByIdAddressResponse = this.modelMapperService.forResponse()
                .map(address, GetByIdAddressResponse.class);

        return new DataResult<>(getByIdAddressResponse, true, "Address listed.");

    }

    @Override
    public Result add(CreateAddressRequest createAddressRequest) {

        Address address = this.modelMapperService.forRequest()
                .map(createAddressRequest, Address.class);

        this.addressRepository.save(address);

        return new SuccessResult("Address added.");
    }

    @Override
    public Result update(UpdateAddressRequest updateAddressRequest) {
        Address address = this.modelMapperService.forRequest()
                .map(updateAddressRequest, Address.class);

        address.setId(updateAddressRequest.getId());
        address.setCountry(updateAddressRequest.getCountry());
        address.setCity(updateAddressRequest.getCity());
        address.setStreet(updateAddressRequest.getStreet());
        address.setAddress(updateAddressRequest.getAddress());
        address.setZipCode(updateAddressRequest.getZipCode());

        this.addressRepository.save(address);

        return new SuccessResult("Address updated.");
    }

    @Override
    public Result delete(DeleteAddressRequest deleteAddressRequest) {

        Address address = this.modelMapperService.forRequest()
                .map(deleteAddressRequest, Address.class);
        this.addressRepository.delete(address);

        return new SuccessResult("Address deleted.");
    }
}
