package com.store.store.business.concretes;

import com.store.store.business.abstracts.ShipperService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
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
        List<GetAllShipperResponses> getAllShipperResponses = shippers.stream()
                .map(shipper -> this.modelMapperService.forResponse()
                        .map(shipper, GetAllShipperResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllShipperResponses, true, "Shippers listed.");
    }

    @Override
    public DataResult<GetByIdShipperResponses> getById(int id) {
        return null;
    }

    @Override
    public Result add(CreateShipperRequest createShipperRequest) {
        return null;
    }

    @Override
    public Result update(UpdateShipperRequest updateShipperRequest) {
        return null;
    }

    @Override
    public Result delete(DeleteShipperRequest deleteShipperRequest) {
        return null;
    }
}
