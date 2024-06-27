package com.spring.data.controller;

import com.spring.data.entity.Cart;
import com.spring.data.entity.Order;
import com.spring.data.entity.Product;
import com.spring.data.repository.CartRepository;
import com.spring.data.repository.OrderRepository;
import com.spring.data.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;
//http://localhost:8080/home
@Controller
@RequestMapping("/Cart")
public class CartController {
	@Autowired
    private CartRepository cartRepository;
	@Autowired
    private ProductRepository productRepository;
	 @Autowired
	    private OrderRepository orderRepository;
	@PostMapping("/addToCart")
    public String addToCart(@RequestParam("productId") Long productId, RedirectAttributes redirectAttributes) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            Cart cartItem = new Cart();
            cartItem.setName(product.getName());
            cartItem.setDescription(product.getDescription());
            cartItem.setPrice(product.getPrice());
            cartItem.setUrl(product.getUrl());

             cartRepository.save(cartItem);
            redirectAttributes.addFlashAttribute("success", "Product added to cart successfully!");
            return "redirect:/products";
        } else {
            redirectAttributes.addFlashAttribute("error", "Product not found!");
            return "redirect:/products";
        }
    }
	@PostMapping("/buy-now")
    public String buyNow(@RequestParam("userId") Long userId,
                         @RequestParam("customerName") String customerName,
                         @RequestParam("shippingAddress") String shippingAddress,
                         Model model, RedirectAttributes redirectAttributes) {
        List<Cart> cartItems = cartRepository.findAll();
        double totalAmount = cartItems.stream()
                .collect(Collectors.summingDouble(Cart::getPrice));

        Order order = new Order(userId, customerName, shippingAddress, totalAmount);
        orderRepository.save(order);

        cartRepository.deleteAll(); 
        redirectAttributes.addFlashAttribute("success", "Order placed successfully!");
        return "redirect:/Cart/order-details"; 
    }
	@GetMapping("/CartItem")
	public String viewCart(Model model) {
	    List<Cart> cartItems = cartRepository.findAll();
	    double totalAmount = cartItems.stream()
	            .collect(Collectors.summingDouble(Cart::getPrice));
	    model.addAttribute("cartItems", cartItems);
	    model.addAttribute("totalAmount", totalAmount);
	    return "index";
	}
	@PostMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("cartItemId") Long cartItemId, RedirectAttributes redirectAttributes) {
        cartRepository.deleteById(cartItemId);
        redirectAttributes.addFlashAttribute("success", "Product removed from cart successfully!");
        return "redirect:/Cart/CartItem";
    }
	@GetMapping("/order-details")
    public String orderDetails(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "order-details"; 
    }

}