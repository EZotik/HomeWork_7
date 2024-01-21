package tets;

import org.junit.jupiter.api.Test;

import pages.TextBoxPage;


public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Alex")
                .setEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()
                .nameCheckResult("Alex")
                .emailCheckResult("alex@egorov.com")
                .currentAddressCheckResult("Some street 1")
                .permanentAddressCheckResult("Another street 1");
    }
}
