package tasks;

import facebook.pageobjects.LoginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import orange_hrm.PageObjects.HRMLoginPageObjects;
import orange_hrm.PageObjects.HRMPIMPageObjects;

public class navigateTo {
    public static Performable theURL(String urlType) throws Exception {
        Class url;

        switch (urlType) {
            case "Facebook Login":
                url = LoginPageObjects.class;
                break;
            case "HRM Login":
                url = HRMLoginPageObjects.class;
                break;
            case "HRM Employee List":
                url = HRMPIMPageObjects.class;
                break;
            default:
                throw new Exception("There is no url type: " + urlType);
        }
        return Task.where("{0} access the login url",
                Open.browserOn().the(url));
    }
}