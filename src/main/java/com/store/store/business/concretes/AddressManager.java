package com.store.store.business.concretes;

import com.store.store.business.abstracts.AddressService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import com.store.store.dto.responses.address.GetAllAddressResponses;
import com.store.store.model.Address;
import com.store.store.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
}
