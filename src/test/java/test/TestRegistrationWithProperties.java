package test;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationTest;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

@Tag("simple")
public class TestRegistrationWithProperties extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationTest registrationTest = new RegistrationTest();
    RandomUtils random = new RandomUtils();
    String file = "AH2I0605.jpg";
    String fieldName = "Student Name";
    String fieldEmail = "Student Email";
    String fieldGender = "Gender";
    String fieldMobile = "Mobile";
    String fieldBirthday = "Date of Birth";
    String fieldSubjects = "Subjects";
    String fieldHobbies = "Hobbies";
    String fieldPicture = "Picture";
    String fieldАddress = "Address";
    String fieldStateCity = "State and City";
    String invalidPhoneNumber = " ";

    @Test
    @Feature("Форма Practice Form")
    @DisplayName("Заполнение формы Practice Form с использованием First Name и Last Name из properties")
    void fillFormRegistrationTest() {
        step("Открываем главную страницу", () -> {
            registrationPage.openPage();
        });
        step("Указываем First Name", () -> {
            registrationTest.setFirstName();
        });
        step("Указываем Last Name", () -> {
            registrationTest.setLastName();
        });
        step("Указываем Email", () -> {
            registrationPage.setEmail(random.email);
        });
        step("Указываем Gender", () -> {
            registrationPage.setGender(random.gender);
        });
        step("Указываем Phone Number", () -> {
            registrationPage.setUserNumber(random.phoneNumber);
        });
        step("Указываем Date of Birth", () -> {
            registrationPage.setDateOfBirth(random.dayOfBirth, random.monthOfBirth, random.yearOfBirth);
        });
        step("Указываем Subjects", () -> {
            registrationPage.setSubjects(random.subject);
        });
        step("Указываем Hobbies", () -> {
            registrationPage.setHobbies(random.hobby);
        });
        step("Прикрепляем Picture", () -> {
            registrationPage.setPicture(file);
        });
        step("Указываем Current Address", () -> {
            registrationPage.setUserAddress(random.address);
        });
        step("Указываем State and City", () -> {
            registrationPage.setStateAndCity(random.state, random.city);
        });
        step("Кликаем по кнопке Submit", () -> {
            registrationPage.submit();
        });
        step("Проверяем поля в итоговой таблице", () -> {
            registrationPage.checkResult(fieldName, registrationTest.firstName + " " +
                            registrationTest.lastName)
                    .checkResult(fieldEmail, random.email)
                    .checkResult(fieldGender, random.gender)
                    .checkResult(fieldMobile, random.phoneNumber)
                    .checkResult(fieldBirthday, random.dayOfBirth + " " + random.monthOfBirth + "," + random.yearOfBirth)
                    .checkResult(fieldSubjects, random.subject)
                    .checkResult(fieldHobbies, random.hobby)
                    .checkResult(fieldPicture, file)
                    .checkResult(fieldАddress, random.address)
                    .checkResult(fieldStateCity, random.state + " " + random.city);
        });
    }
}