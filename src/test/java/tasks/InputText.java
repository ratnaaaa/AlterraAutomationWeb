package tasks;

import facebook.pageobjects.LoginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import orange_hrm.PageObjects.HRMLoginPageObjects;
import orange_hrm.PageObjects.HRMPIMPageObjects;

public class InputText {
    public static Performable onField(String fieldType, String value) throws Exception{
        Target field;
        switch (fieldType){
            case "EMAIL_FB":
                field = LoginPageObjects.EMAIL_FIELD;
                break;
            case "PASSWORD_FB":
                field = LoginPageObjects.PASSWORD_FIELD;
                break;
            case "USERNAME_HRM":
                field = HRMLoginPageObjects.USERNAME_FIELD;
                break;
            case "PASSWORD_HRM":
                field = HRMLoginPageObjects.PASSWORD_FIELD;
                break;
            case "HRM firstName":
                field = HRMPIMPageObjects.FIRST_NAME_FIELD;
                break;
            case "HRM lastName":
                field = HRMPIMPageObjects.LAST_NAME_FIELD;
                break;
            case "editMiddleName":
                field = HRMPIMPageObjects.EDIT_MIDDLE_NAME_FIELD;
                break;

            case "employeeName":
                field = HRMPIMPageObjects.EMPLOYEE_NAME;
                break;

            default:
                throw new Exception("There is no field type: " +fieldType);
        }
        return Task.where("{0} input: " + value+ "",
                Enter.theValue(value)
                        .into(field)
        );
    }
}