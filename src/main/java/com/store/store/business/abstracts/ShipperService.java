package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.shipper.CreateShipperRequest;
import com.store.store.dto.requests.shipper.DeleteShipperRequest;
import com.store.store.dto.requests.shipper.UpdateShipperRequest;
import com.store.store.dto.responses.shipper.GetAllShipperResponses;
import com.store.store.dto.responses.shipper.GetByIdShipperResponses;

import java.util.List;

public interface ShipperService {

    DataResult<List<GetAllShipperResponses>> getAll();

    DataResult<GetByIdShipperResponses> getById(int id);

    Result add(CreateShipperRequest createShipperRequest);

    Result update(UpdateShipperRequest updateShipperRequest);

    Result delete(DeleteShipperRequest deleteShipperRequest);

}
