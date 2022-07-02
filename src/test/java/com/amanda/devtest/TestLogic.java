package com.amanda.devtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.amanda.devtest.controller.EmployeeController;

class TestLogic {
	
	EmployeeController empController;

	@Test
	void test() {
		assertEquals("Data not Found!", empController.deleteEmployee((long) 10));
	}

}
