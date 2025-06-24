package me.interview.demo.fruit.controller;

import me.interview.demo.fruit.entity.Fruit;
import me.interview.demo.fruit.repository.FruitRepository;
import me.interview.demo.fruit.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class FruitController {
    @Autowired
    private FruitRepository fruitRepository;
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/")
    public String index(Model model) {
        List<Fruit> fruits = fruitRepository.findAll();
        model.addAttribute("fruits", fruits);
        return "index";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam String customer,
                          @RequestParam(defaultValue = "0") int apple,
                          @RequestParam(defaultValue = "0") int strawberry,
                          @RequestParam(defaultValue = "0") int mango,
                          Model model) {
        int total = 0;
        if ("A".equals(customer)) {
            total = checkoutService.checkoutA(apple, strawberry);
        } else if ("B".equals(customer)) {
            total = checkoutService.checkoutB(apple, strawberry, mango);
        } else if ("C".equals(customer)) {
            total = checkoutService.checkoutC(apple, strawberry, mango);
        } else if ("D".equals(customer)) {
            total = checkoutService.checkoutD(apple, strawberry, mango);
        }
        model.addAttribute("total", total);
        model.addAttribute("customer", customer);
        model.addAttribute("apple", apple);
        model.addAttribute("strawberry", strawberry);
        model.addAttribute("mango", mango);
        // 重新查一次水果列表，保证index页面渲染正常
        List<Fruit> fruits = fruitRepository.findAll();
        model.addAttribute("fruits", fruits);
        return "index";
    }
} 