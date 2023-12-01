package com.store.store.controller;

import com.store.store.business.abstracts.InvoiceService;
import com.store.store.business.dto.requests.invoice.CreateInvoiceRequest;
import com.store.store.business.dto.requests.invoice.DeleteInvoiceRequest;
import com.store.store.business.dto.requests.invoice.UpdateInvoiceRequest;
import com.store.store.business.dto.responses.invoice.GetAllInvoiceResponses;
import com.store.store.business.dto.responses.invoice.GetByIdInvoiceResponses;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@AllArgsConstructor
public class InvoicesController {

    private InvoiceService invoiceService;

    @GetMapping("/getall")
    public DataResult<List<GetAllInvoiceResponses>> getAll() {
        return this.invoiceService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdInvoiceResponses> getById(int id) {
        return this.invoiceService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateInvoiceRequest createInvoiceRequest) {
        return this.invoiceService.add(createInvoiceRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest) {
        return this.invoiceService.update(updateInvoiceRequest);

    }

    @DeleteMapping("/delete")
    public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
        return this.invoiceService.delete(deleteInvoiceRequest);
    }
}
