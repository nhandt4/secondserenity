package secondserenity.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CucumberStudioPage {
    public static Target USERNAME = Target.the("USERNAME").located(By.id("user_email"));
    public static Target PASSWORD = Target.the("PASSWORD").located(By.id("user_password"));
    public static Target LOGIN = Target.the("LOGIN").locatedBy("//input[@name='commit']");
}
