package com.store.store.business.concretes;

import com.store.store.business.abstracts.SupplierService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.supplier.CreateSupplierRequest;
import com.store.store.dto.requests.supplier.DeleteSupplierRequest;
import com.store.store.dto.requests.supplier.UpdateSupplierRequest;
import com.store.store.dto.responses.supplier.GetAllSupplierResponses;
import com.store.store.dto.responses.supplier.GetByIdSupplierResponses;
import com.store.store.model.Supplier;
import com.store.store.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {

    private SupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<GetAllSupplierResponses>> getAll() {

        List<Supplier> suppliers = supplierRepository.findAll();
        List<GetAllSupplierResponses> getAllSupplierResponses = suppliers.stream()
                .map(supplier -> this.modelMapperService.forResponse().map(supplier, GetAllSupplierResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllSupplierResponses, true, "Suppliers listed successfully.");
    }

    @Override
    public DataResult<GetByIdSupplierResponses> getById(int id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Supplier not found."));

        GetByIdSupplierResponses getByIdSupplierResponses = this.modelMapperService.forResponse()
                .map(supplier, GetByIdSupplierResponses.class);

        return new DataResult<>(getByIdSupplierResponses, true, "Supplier listed successfully.");
    }

    @Override
    public Result add(CreateSupplierRequest createSupplierRequest) {

        Supplier supplier = this.modelMapperService.forRequest()
                .map(createSupplierRequest, Supplier.class);

        supplierRepository.save(supplier);

        return new SuccessResult("Supplier added successfully.");
    }

    @Override
    public Result update(UpdateSupplierRequest updateSupplierRequest) {

        Supplier supplier = supplierRepository.findById(updateSupplierRequest.getId())
                .orElseThrow(() -> new DataNotFoundException("Supplier not found."));

        supplier.setId(updateSupplierRequest.getId());
        supplier.setCompanyName(updateSupplierRequest.getCompanyName());
        supplier.setContactName(updateSupplierRequest.getContactName());
        supplier.setContactTitle(updateSupplierRequest.getContactTitle());
        supplier.setPhone(updateSupplierRequest.getPhone());
        supplier.setFax(updateSupplierRequest.getFax());
        supplier.setEmail(updateSupplierRequest.getEmail());
        supplier.setLogoUrl(updateSupplierRequest.getLogoUrl());

        supplierRepository.save(supplier);

        return new SuccessResult("Supplier updated successfully.");
    }

    @Override
    public Result delete(DeleteSupplierRequest deleteSupplierRequest) {

        Supplier supplier = supplierRepository.findById(deleteSupplierRequest.getId())
                .orElseThrow(() -> new DataNotFoundException("Supplier not found."));

        supplierRepository.delete(supplier);

        return new SuccessResult("Supplier deleted successfully.");
    }
}
