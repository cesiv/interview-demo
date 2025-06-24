package me.interview.demo.fruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import me.interview.demo.fruit.entity.Fruit;
import me.interview.demo.fruit.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class FruitApplication implements CommandLineRunner {

	@Autowired
	private FruitRepository fruitRepository;

	public static void main(String[] args) {
		SpringApplication.run(FruitApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (fruitRepository.findByName("苹果") == null) {
			fruitRepository.save(new Fruit("苹果", 8));
		}
		if (fruitRepository.findByName("草莓") == null) {
			fruitRepository.save(new Fruit("草莓", 13));
		}
		if (fruitRepository.findByName("芒果") == null) {
			fruitRepository.save(new Fruit("芒果", 20));
		}
	}

}
