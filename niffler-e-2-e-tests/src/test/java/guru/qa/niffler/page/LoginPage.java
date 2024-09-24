package guru.qa.niffler.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
  private final SelenideElement usernameInput = $("input[name='username']");
  private final SelenideElement passwordInput = $("input[name='password']");
  private final SelenideElement submitButton = $("button[type='submit']");
  private final SelenideElement createAccountButton = $("a.form__register");
  private final SelenideElement errorText = $("p.form__error");

  public MainPage login(String username, String password) {
    usernameInput.setValue(username);
    passwordInput.setValue(password);
    submitButton.click();
    return new MainPage();
  }

  public RegisterPage clickOnCreateAccountButton() {
    createAccountButton.click();
    return new RegisterPage();
  }

  public LoginPage shouldBeErrorText(String errText) {
    errorText.shouldBe(visible);
    errorText.shouldHave(text(errText));
    return this;
  }
}
