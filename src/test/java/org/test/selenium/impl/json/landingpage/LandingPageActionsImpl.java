package org.test.selenium.impl.json.landingpage;

import com.github.hemanthsridhar.support.FilePath;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.test.selenium.actions.landingpage.LandingPageActions;
import org.test.selenium.actions.landingpage.LandingPageAssertions;
import org.test.selenium.actions.searchresults.SearchResultsPageActions;
import org.test.selenium.constants.json.IPageObjects;
import org.test.selenium.impl.json.searchresults.SearchResultsPageActionsImpl;
import org.test.selenium.pages.json.landingpage.LandingPageObjects;

@FilePath(value = IPageObjects.LANDING_PAGE)
public class LandingPageActionsImpl extends LandingPageObjects implements LandingPageActions {

    public LandingPageActionsImpl(WebDriver driver) {
        super(driver);
    }

    @Override
    public LandingPageActionsImpl iSearchFor(String searchText) {
        enterSearchText(searchText);
        return this;
    }

    @Override
    public SearchResultsPageActions when() {
        return new SearchResultsPageActionsImpl(driver);
    }

    @Override
    public LandingPageAssertions then() {
        return new LandingPageAssertionsImpl(driver);
    }

    @Override
    public LandingPageActions and() {
        return this;
    }

    @Override
    public LandingPageActions iAmOnLandingPage() {
        Assertions.assertThat(driver.getTitle().trim()).isEqualTo("Google");
        return this;
    }

    @Override
    public LandingPageActions iClickOnImagesLink() {
        By imagesRelativeLink = RelativeLocator.with(byLocators.linkByText("Images")).toRightOf(byLocators.linkByText("Gmail"));
        driver.findElement(imagesRelativeLink).click();
        return this;
    }
}