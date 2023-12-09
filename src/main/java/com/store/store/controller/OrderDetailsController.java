package com.store.store.controller;

import com.store.store.business.abstracts.OrderDetailService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.orderDetail.CreateOrderDetailRequest;
import com.store.store.dto.requests.orderDetail.DeleteOrderDetailRequest;
import com.store.store.dto.requests.orderDetail.UpdateOrderDetailRequest;
import com.store.store.dto.responses.orderDetail.GetAllOrderDetailResponses;
import com.store.store.dto.responses.orderDetail.GetByIdOrderDetailResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderDetails")
@AllArgsConstructor
public class OrderDetailsController {

    private OrderDetailService orderDetailService;

    @RequestMapping("/getAll")
    public DataResult<List<GetAllOrderDetailResponses>> getAll() {

        return orderDetailService.getAll();
    }

    @RequestMapping("/getById")
    public DataResult<GetByIdOrderDetailResponses> getById(int id) {

        return orderDetailService.getById(id);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody @Valid CreateOrderDetailRequest createOrderDetailRequest) {

        return orderDetailService.add(createOrderDetailRequest);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody UpdateOrderDetailRequest updateOrderDetailRequest) {

        return orderDetailService.update(updateOrderDetailRequest);

    }

    @RequestMapping("/delete")
    public Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {

        return orderDetailService.delete(deleteOrderDetailRequest);
    }
}
