package pages;

import com.codeborne.selenide.SelenideElement;
import config.RegistrationConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationTest {
    RegistrationConfig registrationConfig = ConfigFactory.create(RegistrationConfig.class);
    public String firstName = registrationConfig.firstName();
    public String lastName = registrationConfig.lastName();
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public RegistrationTest setFirstName(){
        firstNameInput.setValue(firstName);
        return this;
    }
    public RegistrationTest setLastName(){
        lastNameInput.setValue(lastName);
        return this;
    }

}
