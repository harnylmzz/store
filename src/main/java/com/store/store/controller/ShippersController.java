package com.store.store.controller;

import com.store.store.business.abstracts.ShipperService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.shipper.CreateShipperRequest;
import com.store.store.dto.requests.shipper.DeleteShipperRequest;
import com.store.store.dto.requests.shipper.UpdateShipperRequest;
import com.store.store.dto.responses.shipper.GetAllShipperResponses;
import com.store.store.dto.responses.shipper.GetByIdShipperResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippers")
@AllArgsConstructor
public class ShippersController {

    private ShipperService shipperService;


    @GetMapping("/getAll")
    public DataResult<List<GetAllShipperResponses>> getAll() {
        return this.shipperService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdShipperResponses> getById(int id) {
        return this.shipperService.getById(id);
    }

    @GetMapping("/add")
    public Result add(@RequestBody @Valid CreateShipperRequest createShipperRequest) {
        return this.shipperService.add(createShipperRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateShipperRequest updateShipperRequest) {
        return this.shipperService.update(updateShipperRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteShipperRequest deleteShipperRequest) {
        return this.shipperService.delete(deleteShipperRequest);
    }
}
