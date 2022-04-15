package orange_hrm.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import tasks.ClickOn;
import tasks.InputText;
import tasks.navigateTo;

public class loginStepDefinitions {
    @Given("{actor} open Orange HRM login page")
    public void loadHRMLoginPage(Actor actor) throws Exception{
        actor.wasAbleTo(navigateTo.theURL("HRM Login"));
    }
    @When("{actor} input username and password")
    public void inputCredentials (Actor actor) throws Exception {
        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("USERNAME_HRM");
        String password = dotenv.get("PASSWORD_HRM");

        actor.attemptsTo(
                InputText.onField("USERNAME_HRM", username),
                InputText.onField("PASSWORD_HRM", password));
    }
    @And("{actor} click login button")
    public void clickLoginButton (Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("HRM Login")
        );
    }
    @Then("{actor} can login successfully")
    public void validateLoginSuccess(Actor actor){
        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains("/index.php/dashboard")
        );
    }
}