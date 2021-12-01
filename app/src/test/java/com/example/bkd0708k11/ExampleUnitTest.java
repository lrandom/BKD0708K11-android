package com.example.bkd0708k11;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Calculator calculator;
    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        calculator = new Calculator();
    }

    @Test
    public void addition_isCorrect() {
        System.out.println("test 1");
        assertEquals(4, calculator.plus(2,2));
    }

    @Test
    public void sub_isCorrect() {
        System.out.println("test 2");
        assertEquals(2, calculator.sub(4,2));
    }


    @Test
    public void isThrowException() {
        assertThrows(Exception.class, () -> {
            Integer.parseInt("1");
        });
    }

    @Test
    public void isEqualArr() {
        assertArrayEquals(new int[]{2, 3, 4}, new int[]{2, 3, 4});
    }

}