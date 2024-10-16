package com.webwatch.TimeHub.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.webwatch.TimeHub.domain.Cart;
import com.webwatch.TimeHub.domain.CartDetail;
import com.webwatch.TimeHub.service.impl.CartDetailService;
import com.webwatch.TimeHub.service.impl.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    private final CartService cartService;
    private final CartDetailService cartDetailService;

    public CartController(CartService cartService,
            CartDetailService cartDetailService) {
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
    }

    @GetMapping("/cart")
    public String getRegisterPage(
            Model model,
            HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("id");

        Cart cart = this.cartService.findByUserId(userId);
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cd : cartDetails) {
            totalPrice += cd.getPrice() * cd.getQuantity();
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("cart", cart);
        return "client/cart/show";
    }

    @PostMapping("/cart-detail/delete/{id}")
    public String postMethodName(@PathVariable("id") Long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        // find cart detail and cart
        CartDetail cartDetail = this.cartDetailService.findById(id);
        Cart cart = cartDetail.getCart();

        this.cartDetailService.deleteCartDetail(id);
        int currentSum = cart.getSum() - 1;
        cart.setSum(currentSum);
        session.setAttribute("sum", currentSum);

        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");

        Cart cart = this.cartService.findByUserId(id);

        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cd : cartDetails) {
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);

        return "client/cart/checkout";
    }

    @PostMapping("/confirm-checkout")
    public String getCheckoutPage(@ModelAttribute("cart") Cart cart) {
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();
        this.cartDetailService.handleUpdateBeforeCheckout(cartDetails);

        return "redirect:/checkout";
    }

}