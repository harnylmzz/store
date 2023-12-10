package com.store.store.business.concretes;

import com.store.store.business.abstracts.ShipperService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.ErrorDataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.shipper.CreateShipperRequest;
import com.store.store.dto.requests.shipper.DeleteShipperRequest;
import com.store.store.dto.requests.shipper.UpdateShipperRequest;
import com.store.store.dto.responses.shipper.GetAllShipperResponses;
import com.store.store.dto.responses.shipper.GetByIdShipperResponses;
import com.store.store.model.Shipper;
import com.store.store.repository.ShipperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShipperManager implements ShipperService {

    private ShipperRepository shipperRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<GetAllShipperResponses>> getAll() {

        List<Shipper> shippers = this.shipperRepository.findAll();
        List<GetAllShipperResponses> getAllShipperResponses = shippers.stream().map(shipper -> this.modelMapperService.forResponse().map(shipper, GetAllShipperResponses.class)).collect(Collectors.toList());

        return new DataResult<>(getAllShipperResponses, true, "Shippers listed.");
    }

    @Override
    public DataResult<GetByIdShipperResponses> getById(int id) {

        Shipper shipper = this.shipperRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Shipper not found."));

        GetByIdShipperResponses getByIdShipperResponses = this.modelMapperService.forResponse()
                .map(shipper, GetByIdShipperResponses.class);

        return new DataResult<>(getByIdShipperResponses, true, "Shipper listed.");
    }

    @Override
    public Result add(CreateShipperRequest createShipperRequest) {

        Shipper shipper = this.modelMapperService.forRequest()
                .map(createShipperRequest, Shipper.class);

        this.shipperRepository.save(shipper);

        return new SuccessResult("Shipper added.");
    }

    @Override
    public Result update(UpdateShipperRequest updateShipperRequest) {

        Shipper shipper = this.modelMapperService.forRequest()
                .map(updateShipperRequest, Shipper.class);

        shipper.setId(updateShipperRequest.getId());
        shipper.setName(updateShipperRequest.getName());
        shipper.setPhone(updateShipperRequest.getPhone());

        this.shipperRepository.save(shipper);

        return new SuccessResult("Shipper updated.");
    }

    @Override
    public Result delete(DeleteShipperRequest deleteShipperRequest) {

        Shipper shipper = this.modelMapperService.forRequest()
                .map(deleteShipperRequest, Shipper.class);

        this.shipperRepository.delete(shipper);

        return new SuccessResult("Shipper deleted.");
    }
}
