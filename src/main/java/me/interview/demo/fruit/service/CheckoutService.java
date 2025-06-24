package me.interview.demo.fruit.service;

import me.interview.demo.fruit.entity.Fruit;
import me.interview.demo.fruit.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    @Autowired
    private FruitRepository fruitRepository;

    // 顾客A：只买苹果和草莓，无优惠
    public int checkoutA(int apple, int strawberry) {
        int applePrice = getPrice("苹果");
        int strawberryPrice = getPrice("草莓");
        return apple * applePrice + strawberry * strawberryPrice;
    }

    // 顾客B：可以买苹果、草莓、芒果，无优惠
    public int checkoutB(int apple, int strawberry, int mango) {
        int applePrice = getPrice("苹果");
        int strawberryPrice = getPrice("草莓");
        int mangoPrice = getPrice("芒果");
        return apple * applePrice + strawberry * strawberryPrice + mango * mangoPrice;
    }

    // 顾客C：草莓8折
    public int checkoutC(int apple, int strawberry, int mango) {
        int applePrice = getPrice("苹果");
        int strawberryPrice = getPrice("草莓");
        int mangoPrice = getPrice("芒果");
        double strawberryDiscount = 0.8;
        return apple * applePrice + (int)(strawberry * strawberryPrice * strawberryDiscount) + mango * mangoPrice;
    }

    // 顾客D：草莓8折+满100减10
    public int checkoutD(int apple, int strawberry, int mango) {
        int applePrice = getPrice("苹果");
        int strawberryPrice = getPrice("草莓");
        int mangoPrice = getPrice("芒果");
        double strawberryDiscount = 0.8;
        int total = apple * applePrice + (int)(strawberry * strawberryPrice * strawberryDiscount) + mango * mangoPrice;
        if (total >= 100) {
            total -= 10;
        }
        return total;
    }

    private int getPrice(String name) {
        Fruit fruit = fruitRepository.findByName(name);
        return fruit != null ? fruit.getPricePerKg() : 0;
    }
}
