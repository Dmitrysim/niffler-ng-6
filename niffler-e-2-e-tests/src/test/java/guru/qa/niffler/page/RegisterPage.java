package guru.qa.niffler.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    private final SelenideElement header = $("h1.header");
    private final SelenideElement usernameInput = $("input#username");
    private final SelenideElement passwordInput = $("input#password");
    private final SelenideElement submitPasswordInput = $("input#passwordSubmit");
    private final SelenideElement showPassword = $("button#passwordBtn");
    private final SelenideElement showSubmitPassword = $("button#passwordSubmitBtn");
    private final SelenideElement signUpButton = $("button[type='submit']");
    private final SelenideElement linkOnLogin = $("a.form__link");

    public RegisterPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public RegisterPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public RegisterPage setSubmitPassword(String submitPassword) {
        submitPasswordInput.setValue(submitPassword);
        return this;
    }

    public RegisterPage checkInputPassword(String password) {
        showPassword.click();
        passwordInput.shouldHave(text(password));
        return this;
    }

    public RegisterPage checkInputSubmitPassword(String password) {
        showSubmitPassword.click();
        submitPasswordInput.shouldHave(text(password));
        return this;
    }

    public LoginPage submitRegistration() {
        signUpButton.click();
        return new LoginPage();
    }
}
