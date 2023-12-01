package com.store.store.business.abstracts;

import com.store.store.dto.requests.invoice.CreateInvoiceRequest;
import com.store.store.dto.requests.invoice.DeleteInvoiceRequest;
import com.store.store.dto.requests.invoice.UpdateInvoiceRequest;
import com.store.store.dto.responses.invoice.GetAllInvoiceResponses;
import com.store.store.dto.responses.invoice.GetByIdInvoiceResponses;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;

import java.util.List;

public interface InvoiceService {

    DataResult<List<GetAllInvoiceResponses>> getAll();

    DataResult<GetByIdInvoiceResponses> getById(int id);

    Result add(CreateInvoiceRequest createInvoiceRequest);

    Result update(UpdateInvoiceRequest updateInvoiceRequest);

    Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
}
