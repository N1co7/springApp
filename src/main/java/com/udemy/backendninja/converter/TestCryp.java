package com.udemy.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCryp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bCryp = new BCryptPasswordEncoder();
		
		System.out.println(bCryp.encode("user"));

	}

}
