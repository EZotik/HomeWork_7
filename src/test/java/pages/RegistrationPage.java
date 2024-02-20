package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genderWrapper =  $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            calendarInput =  $("#dateOfBirthInput"),
                            subjectsInput = $("#subjectsInput"),
                            hobbiesInput = $("#hobbiesWrapper"),
                            pictureInput = $("#uploadPicture"),
                            userAddressInput = $("#currentAddress"),
                            stateInput = $("#react-select-3-input"),
                            cityInput = $("#react-select-4-input"),
                            submitButton = $("#submit"),
                            checkWindow = $(".modal-content");
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        SelenideElement bannerRoot = $(".fc-consent-root");
        if (bannerRoot.isDisplayed()) {
            bannerRoot.$(byText("Consent")).click();
        }
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String filename){
        pictureInput.uploadFromClasspath(filename);
        return this;
    }

    public RegistrationPage setUserAddress(String value){
        userAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String value1, String value2){
        stateInput.setValue(value1).sendKeys(Keys.ENTER);
        cityInput.setValue(value2).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value){
        resultComponent.checkResult(key, value);
        return this;
    }

    public RegistrationPage checkoutWindow () {
        checkWindow.shouldNotBe(visible);
        return this;

    }
}
