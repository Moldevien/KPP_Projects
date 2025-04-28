package com.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Водій
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
	private String name;
	private int experience;
	// Зарплатня
	private double money;
	// Доступний
	private boolean available = true;
}
