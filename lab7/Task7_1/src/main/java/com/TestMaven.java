package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class TestMaven {
	public static void main(String[] args) {
		Task2();
	}
	
	public static void Task1() {
		List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
		fruits.forEach(System.out::println);
		List<String> reverseFruits = Lists.reverse(fruits);
		reverseFruits.forEach(System.out::println);
		
		Multimap<String, String> map = ArrayListMultimap.create();
		map.put("key", "firstValue");
		map.put("key", "secondValue");
		System.out.println(map);
	}
	
	public static void Task2() {
		Properties prop = new Properties();
		try (InputStream resourceAsStream = TestMaven.class.getClassLoader().getResourceAsStream("config.properties")) {
			prop.load(Objects.requireNonNull(resourceAsStream));
			System.out.println(prop.get("props.local.hello"));
			System.out.println(prop.get("props.mvn.hello"));
		} catch (IOException e) {
			System.err.println("Unable to load properties file : " + "config.properties");
		}
	}
}