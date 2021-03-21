package com.student.tests;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import com.student.tags.Regression;
import com.student.tags.Smoke;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;


@Story("CRUD test")
public class CrudTest extends TestBase {

    RequestFactory requestFactory = new RequestFactory();


    @Story("CRUD test")
    @DisplayName("Test to get all students")
    @Category({Regression.class, Smoke.class})
    @Feature("Test to get all students")
//    @Tag("Smoke")     //for jun it5, to execute like mvn clean test -Dgroup="Regression"
    @Test
    public void getAllStudents() {

        requestFactory.getAllStudents()
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(200);
    }

    @Test
    @Category(Smoke.class)
    @DisplayName("Test to create & verify a new student")
    @Feature("Test to create & verify a new student")
    @Tag("Smoke") //for allure report
    @Story("This is a CRUD testing story")
    public void createNewStudent() {

        Faker fakeData = new Faker();

        String firstName = fakeData.name().firstName();
        String lastName = fakeData.name().lastName();
        String email = fakeData.internet().emailAddress();
        String programme = "Computer Science";
        List<String> courses = new ArrayList<>();
        courses.add("C++");
        courses.add("Java");
        requestFactory.createNewStudent("",
                firstName,
                lastName,
                email,
                programme,
                courses)
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(201);
    }

//    mvn clean test -Dgroup="com.student.tags.Smoke"

}
