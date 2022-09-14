package com.dmcsystemsp.desafio.componentes;

import com.dmcsystemsp.desafio.componentes.entities.Order;
import com.dmcsystemsp.desafio.componentes.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ComponentesApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(ComponentesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Pedido: ");
		Integer code = sc.nextInt();
		System.out.print("Valor Básico: ");
		Double basic = sc.nextDouble();
		System.out.print("% Descontos: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code,basic,discount);

		System.out.printf("Pedido Código : %d\n",order.getCode());
		System.out.printf("Valor total: %.2f%n",orderService.total(order));

	}
}
