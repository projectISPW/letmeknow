package com.example.seleniumGUI;// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;


public class TestCourse {
    String check;
    private WebDriver driver;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testCourse() {
        check="Davide Falessi";
        driver.get("http://inginformatica.uniroma2.it/");
        driver.manage().window().setSize(new Dimension(1552, 832));
        driver.findElement(By.linkText("Corsi")).click();
        driver.findElement(By.cssSelector(".simple-table:nth-child(28) tr:nth-child(6) > td:nth-child(2)")).click();
        assertThat(driver.findElement(By.cssSelector(".simple-table:nth-child(28) tr:nth-child(6) > td:nth-child(2)")).getText(), is(check));
    }
}
