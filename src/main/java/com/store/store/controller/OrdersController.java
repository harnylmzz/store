package com.store.store.controller;

import com.store.store.business.abstracts.OrderService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.order.CreateOrderRequest;
import com.store.store.dto.requests.order.DeleteOrderRequest;
import com.store.store.dto.requests.order.UpdateOrderRequest;
import com.store.store.dto.responses.order.GetAllOrderResponses;
import com.store.store.dto.responses.order.GetByIdOrderResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrdersController {

    private OrderService orderService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllOrderResponses>> getAll() {
        return this.orderService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdOrderResponses> getById(int id) {
        return this.orderService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateOrderRequest createOrderRequest) {
        return this.orderService.add(createOrderRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateOrderRequest updateOrderRequest) {
        return this.orderService.update(updateOrderRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteOrderRequest deleteOrderRequest) {
        return this.orderService.delete(deleteOrderRequest);
    }
}
