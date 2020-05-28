package secondserenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import secondserenity.tasks.Login;
import secondserenity.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class LoginCucumberStudio {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    @Steps
    OpenTheApplication openTheApplication;


    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void login_successful() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(Login.login("qtest13112011@gmail.com","123456aA@"));

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("CucumberStudio | Projects list"))));

    }
}