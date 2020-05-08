package com.filiperibolli.jokenpo.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.filiperibolli.jokenpo.controller.JokenpoController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private JokenpoController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
