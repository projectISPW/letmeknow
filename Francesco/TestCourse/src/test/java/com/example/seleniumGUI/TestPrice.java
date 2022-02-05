package com.example.seleniumGUI;// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
public class TestPrice {
    private WebDriver driver;
    JavascriptExecutor js;
    String searchObj;
    Integer price;
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
    public static String parse(String input){
        input=input.substring(0,input.indexOf(','));
        int index=0;
        char [] toParse=new char[input.length()];
        for (char chr:input.toCharArray()){
            if(chr!='.'){
                toParse[index]=chr;
                index++;
            }
        }
        input= String.valueOf(toParse).substring(0,index);
        return input ;
    }
    @Test
    public void testPrice() {
        searchObj="pc gaming";
        price=2000;
        String compare;
        driver.get("https://shopping.google.it/");
        driver.findElement(By.cssSelector("#yDmH0d > c-wiz > div > div > div > div.NIoIEf > div.G4njw > div.AIC7ge > form > div > div > button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().setSize(new Dimension(1061, 685));
        driver.findElement(By.id("REsRA")).sendKeys(searchObj);
        driver.findElement(By.cssSelector(".uDgUL > svg")).click();
        compare=driver.findElement(By.cssSelector(".shntl:nth-child(2) .hn9kf .translate-content")).getText();
        compare=parse(compare);
        System.out.println(compare);
        assertTrue(price>=Integer.parseInt(compare));
    }
}