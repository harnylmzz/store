package com.store.store.business.concretes;

import com.store.store.business.abstracts.InvoiceService;
import com.store.store.business.dto.requests.invoice.CreateInvoiceRequest;
import com.store.store.business.dto.requests.invoice.DeleteInvoiceRequest;
import com.store.store.business.dto.requests.invoice.UpdateInvoiceRequest;
import com.store.store.business.dto.responses.invoice.GetAllInvoiceResponses;
import com.store.store.business.dto.responses.invoice.GetByIdInvoiceResponses;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.model.Invoice;
import com.store.store.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;

    public DataResult<List<GetAllInvoiceResponses>> getAll() {

        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetAllInvoiceResponses> getAllInvoiceResponses = invoices.stream()
                .map(invoice -> this.modelMapperService.forResponse()
                        .map(invoice, GetAllInvoiceResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllInvoiceResponses, true, "All invoices listed.");
    }

    @Override
    public DataResult<GetByIdInvoiceResponses> getById(int id) {

        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Invoice not found."));

        GetByIdInvoiceResponses getByIdInvoiceResponses = this.modelMapperService.forResponse()
                .map(invoice, GetByIdInvoiceResponses.class);

        return new DataResult<>(getByIdInvoiceResponses, true, "Invoice listed.");
    }

    @Override
    public Result add(CreateInvoiceRequest createInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest()
                .map(createInvoiceRequest, Invoice.class);

        this.invoiceRepository.save(invoice);

        return new SuccessResult("Invoice added.");
    }

    @Override
    public Result update(UpdateInvoiceRequest updateInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest()
                .map(updateInvoiceRequest, Invoice.class);

        invoice.setId(updateInvoiceRequest.getId());
        invoice.setDate(updateInvoiceRequest.getDate());
        invoice.setNumber(updateInvoiceRequest.getNumber());

        this.invoiceRepository.save(invoice);

        return new SuccessResult("Invoice updated.");
    }

    @Override
    public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest()
                .map(deleteInvoiceRequest, Invoice.class);

        this.invoiceRepository.delete(invoice);
        return new SuccessResult("Invoice deleted.");
    }
}
