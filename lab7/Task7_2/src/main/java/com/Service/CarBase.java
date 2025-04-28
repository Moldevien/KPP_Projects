package com.Service;

import com.Model.*;
import lombok.Getter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CarBase {
	Random random = new Random();
	private List<Driver> drivers;
	private List<Car> cars;
	
	@Getter
	private List<Trip> trips = new ArrayList<>();
	
	public CarBase(List<Driver> drivers, List<Car> cars) {
		this.drivers = drivers;
		this.cars = cars;
	}
	
	public Optional<Trip> addRequest(Request request) {
		// Пошук опціонального автомобіля
		Optional<Car> carOpt = cars.stream()
				.filter(car -> car.isAvailable() && car.getCapacity() >= request.getProductMass())
				.sorted((car1, car2) -> Double.compare(car1.getCapacity(), car2.getCapacity()))
				.findFirst();
		
		if (carOpt.isEmpty()) {
			return Optional.empty();
		}
		
		Car car = carOpt.get();
		
		// Визначення складності перевезення товару
		int difficulty;
		switch (request.getProductType()) {
			case HEAVY: {
				difficulty = 5;
				break;
			}
			case MEDIUM: {
				difficulty = 3;
				break;
			}
			default: {
				difficulty = 1;
				break;
			}
		}
		
		//Визначення опціонального водія
		int requiredExp = Math.max(difficulty, Math.max(car.getDifficulty() * 2, (int) (request.getDistance() / 1000)));
		Optional<Driver> driverOpt = drivers.stream()
				.filter(driver -> driver.isAvailable() && driver.getExperience() >= requiredExp)
				.sorted((driver1, driver2) -> Integer.compare(driver1.getExperience(), driver2.getExperience()))
				.findFirst();
		
		if (driverOpt.isEmpty()) {
			return Optional.empty();
		}
		
		Driver driver = driverOpt.get();
		
		// Початок подорожі
		car.setAvailable(false);
		driver.setAvailable(false);
		
		// Подорож
		Trip trip = new Trip(driver, car, request, false, false, 0);
		
		// Подія ламання автомобіля
		boolean isBroken = random.nextDouble() < 0.1;
		trip.setCarBroken(isBroken);
		trip.setCompleted(!isBroken);
		
		// Визначення зарплатні
		double baseRate = 0.5 * request.getDistance();
		switch (request.getProductType()) {
			case HEAVY: {
				baseRate *= 1.5;
				break;
			}
			case MEDIUM: {
				baseRate *= 1.3;
				break;
			}
		}
		
		// Результат подорожі
		if (trip.isCompleted()) {
			trip.setPayment(baseRate);
			trips.add(trip);
			driver.setAvailable(true);
			car.setAvailable(true);
			driver.setMoney(driver.getMoney() + trip.getPayment());
		}
		
		// Логування
		String log = String.format("[%s] Driver: %s, Vehicle: %s, Destination: %s, Status: %s%n",
				LocalDateTime.now(),
				trip.getDriver().getName(),
				trip.getCar().getModel(),
				trip.getRequest().getLocation(),
				trip.isCompleted() ? "Завершено" : "Не вдалося");
		try (FileWriter writer = new FileWriter("trips.log", true)) {
			writer.write(log);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Optional.of(trip);
	}
	
	// Скільки вантажів було перевезено кожним водієм
	public Map<String, Long> getProductCountByDriver() {
		return trips.stream()
				.collect(Collectors.groupingBy(t -> t.getDriver().getName(), Collectors.counting()));
	}
	
	// Скільки вантажів перевезено до конкретного пункту призначення
	public Map<String, Long> getProductCountByDestination() {
		return trips.stream()
				.collect(Collectors.groupingBy(t -> t.getRequest().getLocation(), Collectors.counting()));
	}
	
	// Водії з найбільшим заробітком
	public List<Driver> topEarners(int topN) {
		return drivers.stream()
				.sorted(Comparator.comparingDouble((Driver driver) -> driver.getMoney()).reversed())
				.limit(topN)
				.collect(Collectors.toList());
	}
}
