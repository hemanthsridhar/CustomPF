package org.test.selenium.pages.properties;

import org.test.selenium.actions.landingpage.LandingPageActions;
import org.test.selenium.actions.searchresults.SearchResultsPageActions;
import org.test.selenium.base.DriverFactory;
import org.test.selenium.impl.properties.landingpage.LandingPageActionsImpl;
import org.test.selenium.impl.properties.searchresults.SearchResultsPageActionsImpl;

public interface IPropPage {

    default LandingPageActions landingPageActions() {
        return new LandingPageActionsImpl(DriverFactory.getDriver());
    }

    default SearchResultsPageActions searchResultsPageActions() {
        return new SearchResultsPageActionsImpl(DriverFactory.getDriver());
    }
}