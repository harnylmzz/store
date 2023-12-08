package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.order.CreateOrderRequest;
import com.store.store.dto.requests.order.DeleteOrderRequest;
import com.store.store.dto.requests.order.UpdateOrderRequest;
import com.store.store.dto.responses.order.GetAllOrderResponses;
import com.store.store.dto.responses.order.GetByIdOrderResponses;

import java.util.List;

public interface OrderService {

    DataResult<List<GetAllOrderResponses>> getAll();

    DataResult<GetByIdOrderResponses> getById(int id);

    Result add(CreateOrderRequest createOrderRequest);

    Result update(UpdateOrderRequest updateOrderRequest);

    Result delete(DeleteOrderRequest deleteOrderRequest);
}
