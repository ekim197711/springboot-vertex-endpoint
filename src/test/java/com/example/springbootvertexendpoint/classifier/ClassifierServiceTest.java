package com.example.springbootvertexendpoint.classifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ClassifierServiceTest {
    @Autowired
    ClassifierService classifierService;

    @Test
    void classifyThis() throws IOException {
        byte[] bytes = this.getClass().getClassLoader().getResourceAsStream("example/input_data_rock.json")
                .readAllBytes();
        String input = new String(bytes);
        System.out.printf("Input file: \n%s", input);
        String result = classifierService.classifyThis(input);
        System.out.printf("Result: \n%s", result);
    }
}