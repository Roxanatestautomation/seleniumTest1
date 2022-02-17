package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest extends TestBase {

    @Test
    public void simpleSearchWithOneKeyword1 () {

        //dechiderea unui browser//
        driver.get(AppConfig.getSiteUrl());

        //respectarea principiului do not repeat, principiul sigurantei este respectat
        String searchKeyword = "vase";

        //interactionarea cu elementele din pagina,
        // cauta elementul: campul de cautare (search) si a introduce un text in el//
        driver.findElement(By.id("search")).sendKeys(searchKeyword + Keys.ENTER);

        System.out.println("Press Enter in search field.");

        //adaugarea unui produs in cos//
        //driver.findElement(By.xpath("//div[@class = 'product-info' and ./descendant:: *[text() = 'Herald Glass Vase']]//button[@title='Add to Cart']")).click();

        // stocarea elementelor intr-o lista, II mode h2.product-name > a//
        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name a"));

        System.out.println("Stored " + productNames.size() + " product names.");

        //cum identificam erori/bug-ri cu ajutorul testelor automate, test daca keyword vase se afla in toate produsele de pe pagina
        for(WebElement productName : productNames) {
          assertThat("Some of the products`names do not contain the searched keyword.", productName.getText(), containsString(searchKeyword.toUpperCase()));
        }
    }
}
