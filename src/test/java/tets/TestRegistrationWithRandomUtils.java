package tets;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class TestRegistrationWithRandomUtils extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
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
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.email)
                .setGender(random.gender)
                .setUserNumber(random.phoneNumber)
                .setDateOfBirth(random.dayOfBirth, random.monthOfBirth, random.yearOfBirth)
                .setSubjects(random.subject)
                .setHobbies(random.hobby).setHobbies(random.hobby)
                .setPicture(file)
                .setUserAddress(random.address)
                .setStateAndCity(random.state, random.city)
                .submit()
                .checkResult(fieldName, random.firstName + " " + random.lastName)
                .checkResult(fieldEmail, random.email)
                .checkResult(fieldGender, random.gender)
                .checkResult(fieldMobile, random.phoneNumber)
                .checkResult(fieldBirthday, random.fullBirthDate)
                .checkResult(fieldSubjects, random.subject)
                .checkResult(fieldHobbies, random.hobby + "," + random.hobby)
                .checkResult(fieldPicture, file)
                .checkResult(fieldАddress, random.address)
                .checkResult(fieldStateCity, random.state + " " + random.city);
    }

    @Test
    void minDataFillFormTest() {
        registrationPage.openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.email)
                .setGender(random.gender)
                .setUserNumber(random.phoneNumber)
                .setDateOfBirth(random.dayOfBirth, random.monthOfBirth, random.yearOfBirth)
                .setUserAddress(random.subject)
                .submit()
                .checkResult(fieldName, random.firstName + " " + random.lastName)
                .checkResult(fieldEmail, random.email)
                .checkResult(fieldGender, random.gender)
                .checkResult(fieldMobile, random.phoneNumber)
                .checkResult(fieldBirthday, random.fullBirthDate)
                .checkResult(fieldАddress, random.address);

    }

    @Test
    void negativeFillFormTest() {
        registrationPage.openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.email)
                .setGender(random.gender)
                .setUserNumber(invalidPhoneNumber)
                .submit()
                .checkoutWindow();
    }


}
