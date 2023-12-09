package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.orderDetail.CreateOrderDetailRequest;
import com.store.store.dto.requests.orderDetail.DeleteOrderDetailRequest;
import com.store.store.dto.requests.orderDetail.UpdateOrderDetailRequest;
import com.store.store.dto.responses.orderDetail.GetAllOrderDetailResponses;
import com.store.store.dto.responses.orderDetail.GetByIdOrderDetailResponses;

import java.util.List;

public interface OrderDetailService {

    DataResult<List<GetAllOrderDetailResponses>> getAll();

    DataResult<GetByIdOrderDetailResponses> getById(int id);

    Result add(CreateOrderDetailRequest createOrderDetailRequest);

    Result update(UpdateOrderDetailRequest updateOrderDetailRequest);

    Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
}
