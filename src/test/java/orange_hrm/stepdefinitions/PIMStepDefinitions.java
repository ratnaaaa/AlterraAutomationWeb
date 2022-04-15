package orange_hrm.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import orange_hrm.PageObjects.HRMPIMPageObjects;
import tasks.*;

public class PIMStepDefinitions {

    // Read Employee - Begin
    @And("{actor} access employee list")
    public void accessEmployee(Actor actor) throws Exception{
        actor.wasAbleTo(navigateTo.theURL("HRM Employee List"));
    }
    @And("{actor} can see new employee list result")
    public void listResult(Actor actor) throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("Employee List")
        );
    }
    // Read Employee - End

    // add Employee -Begin
    @When("{actor} add new employee with required field only")
    public void addEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("ADD"),
                InputText.onField("HRM firstName", "Ratna"),
                InputText.onField("HRM lastName", "Khoerunnisa"),
                ClickOn.button("Save")
        );
    }
    @Then("{actor} can see my Personal Details")
    public void personalDetails(Actor actor)throws Exception{
        actor.attemptsTo(VerifyDisplayed.element("Personal Detail"));
    }
    // Add Employee - End

    // Search Employee - Begin
    @And("{actor} search for new employee")
    public void filterEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                InputText.onField("employeeName", "Ratna"),
                ClickOn.button("Search")
        );
    }
    // Search Employee - End

    // Update Employee - Begin
    @When("{actor} update new employee's middle name")
    public void updateEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.employeeList(),
                ClickOn.button("Edit"),
                InputText.onField("editMiddleName", "ratnaaa"),
                ClickOn.button("Save")
        );
    }

    @Then("{actor} can see the Personal Details has Changed")
    public void updatedEmployee(Actor actor){
        actor.attemptsTo(
                Ensure.that(HRMPIMPageObjects.EDIT_MIDDLE_NAME_FIELD).value().isEqualTo("ratnaaa")
        );
    }
    // Update Employee - End

    // Delete Employee - Begin
    @And("{actor} delete new employee")
    public void deleteEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.checkbox(),
                ClickOn.button("Delete"),
                ClickOn.button("OK")
        );
    }

    @Then("{actor} can't see deleted employee on list")
    public void deletedEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("No Employee")
        );
    }

}