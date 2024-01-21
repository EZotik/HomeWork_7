package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            userCurrentAddressInput = $("#currentAddress"),
            userPermanentAddressInput =  $("#permanentAddress"),
            submitButton = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage(){
        open("/text-box");
        return this;
    }
    public TextBoxPage setUserName(String value){
        userNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAddress(String value){
        userCurrentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddress(String value){
        userPermanentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage nameCheckResult(String name) {
        resultName.shouldHave(text("Name:" + name));
        return this;
    }
    public TextBoxPage emailCheckResult(String email) {
        resultEmail.shouldHave(text("Email:" + email));
        return this;
    }
    public TextBoxPage currentAddressCheckResult(String currentAddress) {
        resultCurrentAddress.shouldHave(text("Current Address :" + currentAddress));

        return this;
    }
    public TextBoxPage permanentAddressCheckResult(String permanentAddress) {
        resultPermanentAddress.shouldHave(text("Permananet Address :" + permanentAddress));
        return this;
    }
}
