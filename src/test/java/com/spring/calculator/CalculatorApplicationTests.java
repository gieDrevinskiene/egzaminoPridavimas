package com.spring.calculator;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class CalculatorApplicationTests {
    @Before
    public void setUp(){
        Calculator.setUp(Calculator.URL);

    }
    @Test
    public void registerNewAccountPositiveTest() throws InterruptedException {
        boolean registerResult = Calculator.registerNewaccount("aaa2","aaa","aaa");
        Assert.assertEquals(true, registerResult);
        Calculator.closeBrowser();
    }
    @Test
    public void registerNewAccountNegativeTest() throws InterruptedException {
        boolean registerResult = Calculator.registerNewaccount("aa1","aa","aaa");
        Assert.assertEquals(false,registerResult);
        Calculator.closeBrowser();
    }

    @Test
    public void loginPositiveTest() throws InterruptedException {
        boolean loginResult = Calculator.login("giedre","giedre");
        Assert.assertEquals(true, loginResult);
        Calculator.closeBrowser();
    }

    @Test
    public void loginNegativeTest() throws InterruptedException {
        boolean registerResult = Calculator.login("giedre", "gi");
        Assert.assertEquals(false,registerResult);
        Calculator.closeBrowser();
    }

    @Test
    public void calculatePositiveTest() throws InterruptedException {
        Calculator.login("giedre","giedre");
        String calculateResult = Calculator.calculate(4,"*",4);
        Assert.assertEquals("4 * 4 = 16", calculateResult);
        Calculator.closeBrowser();
    }

    @Test
    public void calculatorNegativeTest() throws InterruptedException {
        Calculator.login("giedre","giedre");
        String calculatorResult = Calculator.calculate(-4,"*",4);
        Assert.assertEquals("Validacijos klaida: skaičius negali būti neigiamas", calculatorResult);
        Calculator.closeBrowser();
    }

    @Test
    public void searchPositiveTest() throws InterruptedException {
        Calculator.login("giedre","giedre");
        boolean searchResult = Calculator.searchData(28);
        Assert.assertEquals(true, searchResult);
        Calculator.closeBrowser();
    }

    @Test
    public void searchNegativeTest() throws InterruptedException {
        Calculator.login("giedre","giedre");
        boolean searchResult = Calculator.searchData(-28);
        Assert.assertEquals(false, searchResult);
        Calculator.closeBrowser();
    }

    @Test
    public  void PositiveAuthorizationTest() throws InterruptedException {
        Calculator.login("giedre","giedre");
        String result = Calculator.calculateUsingUrl(2,"*",2);
        Assert.assertEquals("2 * 2 = 4", result);
        Calculator.closeBrowser();
    }
    @Test
    public void negativeAuthorizationTest(){
        try {
            String result = Calculator.calculateUsingUrl(2,"*",2);
            Assert.fail();
        } catch (NoSuchElementException e){

        }

    }

}