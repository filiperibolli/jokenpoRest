package com.filiperibolli.jokenpo.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.filiperibolli.jokenpo.service.JokenpoService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTest {

    @Autowired
    JokenpoService jokenpoService;

    @DisplayName("Test Spring @Autowired Service Integration findById")
    @Test
    void testGetFindById() {
        assertEquals("Jogador1", jokenpoService.findById("Jogador1").get().getPlayerId());
    }
    
    @DisplayName("Test Spring @Autowired Service Integration save")
    @Test
    void testGetSave() {
        assertEquals("Jogador1", jokenpoService.save("Jogador1"));
    }

}