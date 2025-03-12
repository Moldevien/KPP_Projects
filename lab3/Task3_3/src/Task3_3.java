// Створіть змінну “Зоопарк”. Виведіть на екран кількість хижаків, які проживають у зоопарку,
// визначте обсяг корму різних категорій необхідного для нормального існування Зоопарку

import Model.*;

import java.util.Arrays;

public class Task3_3 {
	public static void main(String[] args) {
		Animal[] zoo = new Animal[]{
				new Tiger("Тигр"),
				new Rabbit("Кролик"),
				new Wolf("Вовк"),
				new Kangaroo("Кенгуру")
		};
		
		// Виведення всіх тварин в зоопарку
		System.out.println("Виведення всіх тварин в зоопарку");
		for (Animal animal : zoo)
			System.out.println(animal.getName());
		
		// Виведення кількості хижаків
		System.out.println("Кількість хижаків у зоопарку: " + Arrays.stream(zoo)
				.filter(animal -> animal.isPredator()).count());
		
		// Виведення загального обсягу корму
		System.out.print("Загальний обсяг корму для всіх тварин: ");
		double sum = 0;
		for (Animal animal : zoo)
			sum += animal.getFoodQuantity();
		System.out.println(sum+" кг");
	}
}
