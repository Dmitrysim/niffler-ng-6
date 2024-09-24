package guru.qa.niffler.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {

    private final SelenideElement showArchivedCheckbox = $("input[type='checkbox']");
    private final ElementsCollection categoryList = $$(".MuiChip-filled");

    public ProfilePage clickOnShowArchivedCheckbox() {
        showArchivedCheckbox.click();
        return this;
    }
}
