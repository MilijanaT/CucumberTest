package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Product;
import org.example.Search;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SearchProduct {
    Product product;
    Search search;

    @Given("I have a search field on GreatProducts Page")
    public void i_have_a_search_field_on_GreatProducts_Page() {
        System.out.println("Step 1: I am on search page");
    }

    @When("I search for a product with name {string} and price {int}")
    public void i_search_for_a_product_with_name_and_price(String productName, Integer price) {
        System.out.println("Step 1: I search for a product with name "+productName+" and price "+price);
        product = new Product(productName, price);
    }

    @Then("Product with name {string} should be displayed")
    public void product_with_name_should_be_displayed(String productName) {
        System.out.println("Step 3: product "+ productName +" is displayed");
        search = new Search();
        String name = search.displayProduct(product);
        System.out.println("searched product is: "+ name);
        assertEquals(productName, name);
    }

}
