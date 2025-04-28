package com.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Запрос
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
	private String location;
	private double distance;
	private double productMass;
	private ProductType productType;
}
