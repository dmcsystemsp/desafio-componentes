package com.dmcsystemsp.desafio.componentes.services;

import com.dmcsystemsp.desafio.componentes.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private  ShippingService shippingService;

    public double total(Order order){
        double valorDescontos = order.getBasic() * order.getDiscount() / 100;
        return order.getBasic() - valorDescontos + shippingService.shipment(order);
    }
}
