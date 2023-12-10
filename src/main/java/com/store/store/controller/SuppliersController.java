package com.store.store.controller;

import com.store.store.business.abstracts.SupplierService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.supplier.CreateSupplierRequest;
import com.store.store.dto.requests.supplier.DeleteSupplierRequest;
import com.store.store.dto.requests.supplier.UpdateSupplierRequest;
import com.store.store.dto.responses.supplier.GetAllSupplierResponses;
import com.store.store.dto.responses.supplier.GetByIdSupplierResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("(api/v1/suppliers)")
@AllArgsConstructor
public class SuppliersController {

    private SupplierService supplierService;

    @GetMapping("/getall")
    public DataResult<List<GetAllSupplierResponses>> getAll() {
        return this.supplierService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdSupplierResponses> getById(int id) {
        return this.supplierService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateSupplierRequest createSupplierRequest) {
        return this.supplierService.add(createSupplierRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return this.supplierService.update(updateSupplierRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteSupplierRequest deleteSupplierRequest) {
        return this.supplierService.delete(deleteSupplierRequest);
    }

}
