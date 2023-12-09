package com.store.store.business.concretes;

import com.store.store.business.abstracts.OrderDetailService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.orderDetail.CreateOrderDetailRequest;
import com.store.store.dto.requests.orderDetail.DeleteOrderDetailRequest;
import com.store.store.dto.requests.orderDetail.UpdateOrderDetailRequest;
import com.store.store.dto.responses.orderDetail.GetAllOrderDetailResponses;
import com.store.store.dto.responses.orderDetail.GetByIdOrderDetailResponses;
import com.store.store.model.OrderDetail;
import com.store.store.repository.OrderDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<GetAllOrderDetailResponses>> getAll() {

        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        List<GetAllOrderDetailResponses> getAllOrderDetailResponses = orderDetails.stream()
                .map(orderDetail -> modelMapperService.forResponse()
                        .map(orderDetail, GetAllOrderDetailResponses.class))
                .collect(Collectors.toList());
        return new DataResult<>(getAllOrderDetailResponses, true, "Order details listed");
    }

    @Override
    public DataResult<GetByIdOrderDetailResponses> getById(int id) {

        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Order detail not found"));
        GetByIdOrderDetailResponses getByIdOrderDetailResponses = modelMapperService.forResponse()
                .map(orderDetail, GetByIdOrderDetailResponses.class);
        return new DataResult<>(getByIdOrderDetailResponses, true, "Order detail listed");
    }

    @Override
    public Result add(CreateOrderDetailRequest createOrderDetailRequest) {

        OrderDetail orderDetail = modelMapperService.forRequest()
                .map(createOrderDetailRequest, OrderDetail.class);
        orderDetailRepository.save(orderDetail);
        return new SuccessResult("Order detail added");
    }

    @Override
    public Result update(UpdateOrderDetailRequest updateOrderDetailRequest) {

        OrderDetail orderDetail = modelMapperService.forRequest()
                .map(updateOrderDetailRequest, OrderDetail.class);

        orderDetail.setId(updateOrderDetailRequest.getId());
        orderDetail.setQuantity(updateOrderDetailRequest.getQuantity());
        orderDetail.setUnitPrice(updateOrderDetailRequest.getUnitPrice());
        orderDetail.setDiscount(updateOrderDetailRequest.getDiscount());
        orderDetail.setTotal(updateOrderDetailRequest.getTotal());
        orderDetail.setSize(updateOrderDetailRequest.getSize());
        orderDetail.setColor(updateOrderDetailRequest.getColor());
        orderDetail.setFulfilled(updateOrderDetailRequest.getFulfilled());
        orderDetail.setStatus(updateOrderDetailRequest.getStatus());
        orderDetail.setBillDate(updateOrderDetailRequest.getBillDate());

        orderDetailRepository.save(orderDetail);

        return new SuccessResult("Order detail updated");
    }

    @Override
    public Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {

        OrderDetail orderDetail = modelMapperService.forRequest()
                .map(deleteOrderDetailRequest, OrderDetail.class);

        orderDetailRepository.delete(orderDetail);

        return new SuccessResult("Order detail deleted");
    }
}
