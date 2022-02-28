package org.fasttrackit;

import org.fasttrackit.webviews.Header;
import org.fasttrackit.webviews.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest extends TestBase {

    @Test
    public void simpleSearchWithOneKeyword1() {

        openHomePage();

        Header header = PageFactory.initElements(driver, Header.class);

        String searchKeyword = "vase";
        header.search(searchKeyword);

        System.out.println("Press Enter in search field.");

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        System.out.println("Stored " + productsGrid.getProductNames().size() + " product names.");

        for (WebElement productName : productsGrid.getProductNames()) {
            assertThat("Some of the products`names do not contain the searched keyword.", productName.getText(), containsString(searchKeyword.toUpperCase()));
        }
    }
}
