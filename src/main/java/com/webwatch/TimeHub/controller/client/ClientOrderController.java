package com.webwatch.TimeHub.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webwatch.TimeHub.domain.Order;
import com.webwatch.TimeHub.domain.User;
import com.webwatch.TimeHub.service.impl.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientOrderController {

    private final OrderService orderService;

    public ClientOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place-order")
    public String handlePlaceOrder(
            HttpServletRequest request,
            @RequestParam("receiverName") String receiverName,
            @RequestParam("receiverAddress") String receiverAddress,
            @RequestParam("receiverPhone") String receiverPhone) {
        HttpSession session = request.getSession(false);
        Long id = (Long) session.getAttribute("id");
        User currentUser = new User();
        currentUser.setId(id);

        Order order = this.orderService.handlePlaceOrder(currentUser, session, receiverName, receiverAddress,
                receiverPhone);
        Long orderId = order.getId();
        return "redirect:/generate-bill/" + orderId;
    }

    @GetMapping("/thank-you")
    public String getMethodName() {
        return "client/cart/thankyou";
    }

}
