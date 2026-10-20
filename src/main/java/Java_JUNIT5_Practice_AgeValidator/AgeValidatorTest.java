package Java_JUNIT5_Practice_AgeValidator;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AgeValidatorTest {

    AgeValidator av;

    @BeforeAll
    static void beforeMessage(){
        System.out.println("Started Tests");
    }

    @BeforeEach
    void setup(){

        av = new AgeValidator();

    }

    @Test
    void PersonAgeIsOver17(){

        assertTrue(av.isAdult(19));
        assertTrue(av.isAdult(54));
        assertTrue(av.isAdult(119));

    }

    @ParameterizedTest
    @CsvSource({
            "15",
            "0",
            "11"
    })
    void PersonAgeIsBelow18(int age){

        assertFalse(av.isAdult(age));

    }

    @ParameterizedTest
    @CsvSource({
            "15, false",
            "0, false",
            "11, false",
            "21, true",
            "59, true",
            "120, true",
            "00, false",
    })
    void PersonIsAdultOrNot(int age, boolean expected){

        assertEquals(expected, av.isAdult(age));

    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "130",
            "-90",
    })
    void PersonAgeIsValidOrNot(int age){

        assertThrows(
                IllegalArgumentException.class,
                () -> av.validateAge(age),
                "Expected an exception for invalid age: " + age
                );

    }

    @AfterEach
    void cleanUp(){
        av = null;
    }

    @AfterAll
    static void afterMessage(){
        System.out.println("Completed All Tests");
    }

}