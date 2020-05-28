package secondserenity.tasks;

import secondserenity.ui.CucumberStudio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;


public class OpenTheApplication implements Task {

    CucumberStudio cucumberStudio;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(cucumberStudio)
        );
    }
}
