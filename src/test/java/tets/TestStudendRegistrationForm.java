package tets;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class TestStudendRegistrationForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Ekaterina")
                .setLastName("Zotova")
                .setEmail("zotova23@mail.ru")
                .setGender("Female")
                .setUserNumber("7495641005")
                .setDateOfBirth("13", "November", "1989")
                .setSubjects("M")
                .setHobbies("Sports").setHobbies("Reading")
                .setPicture("AH2I0605.jpg")
                .setUserAddress("123456,Moscow region, Moscow, st. Moskovskaya 12, apt. 100")
                .setStateAndCity("NCR", "Delhi")
                .submit()
                .checkResult("Student Name", "Ekaterina Zotova")
                .checkResult("Student Email", "zotova23@mail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7495641005")
                .checkResult("Date of Birth", "13 November,1989")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading")
                .checkResult("Picture", "AH2I0605.jpg")
                .checkResult("Address", "123456,Moscow region, Moscow, st. Moskovskaya 12, apt. 100")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void minDataFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Ekaterina")
                .setLastName("Zotova")
                .setEmail("zotova23@mail.ru")
                .setGender("Female")
                .setUserNumber("7495641005")
                .setDateOfBirth("13", "November", "1989")
                .setUserAddress("123456,Moscow region, Moscow, st. Moskovskaya 12, apt. 100")
                .submit()
                .checkResult("Student Name", "Ekaterina Zotova")
                .checkResult("Student Email", "zotova23@mail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7495641005")
                .checkResult("Date of Birth", "13 November,1989")
                .checkResult("Address", "123456,Moscow region, Moscow, st. Moskovskaya 12, apt. 100");

    }

    @Test
    void negativeFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Ekaterina")
                .setLastName("Zotova")
                .setEmail("zotova23@mail.ru")
                .setGender("Female")
                .setUserNumber(" ")
                .submit()
                .checkoutWindow();
    }


}
