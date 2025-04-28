package com.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Поїздка
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
	private Driver driver;
	private Car car;
	private Request request;
	private boolean completed;
	private boolean carBroken;
	private double payment;
}
