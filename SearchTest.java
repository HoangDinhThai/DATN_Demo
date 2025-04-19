package DATN.E_commerce;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void searchWithValidKeyword() {
        performSearch("iphone 16 promax");
    }

    @Test(priority = 2)
    public void searchWithInvalidKeyword() {
        performSearch("abc123");
    }

    @Test(priority = 3)
    public void searchWithSpecialCharacters() {
        performSearch("!@#aabs");
    }
}
