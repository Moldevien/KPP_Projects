package com;

import com.Model.*;
import com.Service.CarBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

public class CarBaseTest {
	CarBase carBase;
	List<Driver> drivers;
	List<Car> cars;
	
	@BeforeEach
	void setUp() {
		// Створення водіїв
		drivers = Arrays.asList(
				new Driver("Іван", 2, 0, true),
				new Driver("Петро", 5, 0, true),
				new Driver("Олена", 7, 0, true)
		);
		
		// Створення автомобілів
		cars = Arrays.asList(
				new Car("Газель", 1000, 1, true),
				new Car("Камаз", 500, 3, true),
				new Car("MAN", 10000, 5, true)
		);
		
		carBase = new CarBase(drivers, cars);
	}
	
	@Test
	public void testRequest() {
		// Створення заявок
		Request request = new Request("Київ", 800, 200, ProductType.LIGHT);
		
		
		// Обробка заявок
		carBase.addRequest(request).ifPresentOrElse(
				trip -> System.out.println("Успішно призначено рейс: " + trip + '\n'),
				() -> System.out.println("Не вдалося призначити рейс для заявки: " + request)
		);
		
		Assertions.assertFalse(carBase.getTrips().isEmpty());
	}
}