package secondserenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import secondserenity.ui.CucumberStudioPage;

public class Login implements Task {

    private final String userName;
    private final String passWord;

    protected Login(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Step("Login successfully")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userName)
                        .into(CucumberStudioPage.USERNAME),
                Enter.theValue(passWord).into(CucumberStudioPage.PASSWORD),
                Click.on(CucumberStudioPage.LOGIN)
        );
    }

    public static Login login(String userName, String passWord) {
        return instrumented(Login.class, userName, passWord);
    }

}
