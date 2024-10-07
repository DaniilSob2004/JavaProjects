package com.example.AutoBase.controller;

import com.example.AutoBase.dto.MessageDto;
import com.example.AutoBase.dto.OrderCreateDto;
import com.example.AutoBase.dto.OrderDto;
import com.example.AutoBase.dto.OrderFilterDto;
import com.example.AutoBase.exceptions.CargoTypeIsNotFoundByIdException;
import com.example.AutoBase.exceptions.CityIsNotFoundByIdException;
import com.example.AutoBase.service.CreateOrderService;
import com.example.AutoBase.service.busines.cargotypeservice.CargoTypeService;
import com.example.AutoBase.service.busines.cityservice.CityService;
import com.example.AutoBase.service.busines.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Value("${value.title}")
    private String pageTitle;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CargoTypeService cargoTypeService;

    @Autowired
    private CreateOrderService createOrderService;


    @GetMapping(value = "orders/get")
    public String getOrders(@ModelAttribute OrderFilterDto orderFilterDto, Model model) {
        System.out.println(orderFilterDto);

        List<OrderDto> ordersDto;
        if (orderFilterDto.getIsFlight() == null) {
            ordersDto = orderService.findAllDto();
        }
        else {
            ordersDto = orderService.findByFilter(orderFilterDto);
        }

        model.addAttribute("ordersDto", ordersDto);
        model.addAttribute("orderFilterDto", orderFilterDto);
        return "orders";
    }


    @GetMapping(value = "order/create")
    public String createOrderPage(Model model) {
        model.addAttribute("title", pageTitle);
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("cargoTypes", cargoTypeService.findAll());
        return "createOrder";
    }

    @PostMapping(value = "order/create")
    public String createOrder(@RequestParam("orderCreateDto") OrderCreateDto orderCreateDto, Model model) {
        System.out.println(orderCreateDto.toString());

        MessageDto messageDto = new MessageDto();
        try {
            createOrderService.createOrder(orderCreateDto);  // создаём заявку
            messageDto.setMessage("Order successfully created");
            messageDto.setColor("darkgreen");
        } catch (CityIsNotFoundByIdException | CargoTypeIsNotFoundByIdException e) {
            messageDto.setMessage(e.getMessage());
            messageDto.setColor("darkred");
        }
        model.addAttribute("message", messageDto);

        return "redirect:/orders/get";
    }


    @PostMapping(value = "order/to-flight")
    public String orderToFlight(@RequestParam("orderId") int orderId, Model model) {
        System.out.println("TO FLIGHT, id: " + orderId);
        return "main";
    }
}
