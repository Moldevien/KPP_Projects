package com.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Автомобіль
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private String model;
	// Вантажопідйомність
	private double capacity;
	// Складність
	private int difficulty;
	// Доступний
	private boolean available = true;
}
