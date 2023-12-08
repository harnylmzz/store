package com.store.store.business.concretes;

import com.store.store.business.abstracts.OrderService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.order.CreateOrderRequest;
import com.store.store.dto.requests.order.DeleteOrderRequest;
import com.store.store.dto.requests.order.UpdateOrderRequest;
import com.store.store.dto.responses.order.GetAllOrderResponses;
import com.store.store.dto.responses.order.GetByIdOrderResponses;
import com.store.store.model.Order;
import com.store.store.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllOrderResponses>> getAll() {

        List<Order> orders = orderRepository.findAll();
        List<GetAllOrderResponses> getAllOrderResponses = orders.stream()
                .map(order -> this.modelMapperService.forResponse()
                        .map(order, GetAllOrderResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllOrderResponses, true, "All orders listed.");
    }

    @Override
    public DataResult<GetByIdOrderResponses> getById(int id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Order not found."));

        GetByIdOrderResponses getByIdOrderResponses = this.modelMapperService.forResponse()
                .map(order, GetByIdOrderResponses.class);

        return new DataResult<>(getByIdOrderResponses, true, "Order listed.");
    }

    @Override
    public Result add(CreateOrderRequest createOrderRequest) {

        Order order = this.modelMapperService.forRequest()
                .map(createOrderRequest, Order.class);
        this.orderRepository.save(order);

        return new SuccessResult("Order added.");
    }

    @Override
    public Result update(UpdateOrderRequest updateOrderRequest) {

        Order order = this.modelMapperService.forRequest()
                .map(updateOrderRequest, Order.class);

        order.setId(updateOrderRequest.getId());
        order.setNumber(updateOrderRequest.getNumber());
        order.setDate(updateOrderRequest.getDate());
        order.setFreight(updateOrderRequest.getFreight());
        order.setTotal(updateOrderRequest.getTotal());
        order.setStatus(updateOrderRequest.getStatus());
        order.setComment(updateOrderRequest.getComment());

        this.orderRepository.save(order);

        return new SuccessResult("Order updated.");
    }

    @Override
    public Result delete(DeleteOrderRequest deleteOrderRequest) {

        Order order = this.modelMapperService.forRequest()
                .map(deleteOrderRequest, Order.class);

        this.orderRepository.delete(order);

        return new SuccessResult("Order deleted.");
    }
}
