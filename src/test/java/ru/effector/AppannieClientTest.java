package ru.effector;

import org.junit.Assert;
import org.junit.Test;
import ru.effector.condition.BaseCondition;
import ru.effector.condition.RankCondition;
import ru.effector.condition.SaleCondition;
import ru.effector.interfaces.Accounts;
import ru.effector.interfaces.Meta;
import ru.effector.model.*;
import ru.effector.responses.*;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class AppannieClientTest {

    private final AppannieClient client = new AppannieClient("3a5cfea52747a72e66c27f82d7f2ab65a2ecc7e1");

    @Test
    public void testAccounts() {
        Accounts accounts = client.accounts();
        AccountResponse accountList = accounts.accounts(0);
        Assert.assertNotNull(accountList);

        Account account = accountList.accounts.iterator().next();
        BasicResponse productList = accounts.accountProducts(account.accountId, 0);
        Assert.assertNotNull(productList);
    }

    @Test
    public void testProductDetails() {
        BasicResponse details = client.products().details(Vertical.apps, Market.ios, Asset.app, 693635776);
        Assert.assertNotNull(details);
    }

    @Test
    public void testProductRank() {
        BasicResponse response = client.products().ranks(Vertical.apps, Market.ios, Asset.app, 693635776, new RankCondition());
        Assert.assertNotNull(response);
    }

    @Test
    public void testProductFeatures() {
        BaseCondition condition = new BaseCondition();
        condition.startDate = "2015-08-04";
        condition.endDate = "2015-08-04";

        BasicResponse response = client.products().features(Vertical.apps, Market.ios, Asset.app, 693635776, condition);
        Assert.assertNotNull(response);
    }

    @Test
    public void testProductSales() {
        SaleCondition condition = new SaleCondition();
        condition.startDate = "2015-08-04";
        condition.endDate = "2015-08-04";

        BasicResponse response = client.accounts().sales(109573, 693635776, condition);
        Assert.assertNotNull(response);
    }

    @Test
    public void testProductRank1() {
        RankCondition condition = new RankCondition();
        condition.endDate = "2015-06-06";
        condition.interval = Interval.daily;
        ProductRanksResponse response = client.products().ranks(Vertical.apps, Market.ios, Asset.app, 693635776, condition);
        Assert.assertNotNull(response);
    }

    @Test
    public void testProductRatings() {
        ProductRatingsResponse response = client.products().ratings(Vertical.apps, Market.ios, Asset.app, 693635776, 0);
        Assert.assertNotNull(response);
    }

    @Test
    public void testMeta() {
        Meta meta = client.meta();

        FeedResponse feeds = meta.feeds(Vertical.apps, Market.windows_store);
        Assert.assertNotNull(feeds);

        DevicesResponse devices = meta.devices(Vertical.apps, Market.windows_store);
        Assert.assertNotNull(devices);

        CurrenciesResponse currencies = meta.currencies();
        Assert.assertNotNull(currencies);

        MarketsResponse markets = meta.markets();
        Assert.assertNotNull(markets);

        CategoriesResponse categories = meta.categories(Vertical.apps, Market.google_play);
        Assert.assertNotNull(categories);

        CountriesResponse countries = meta.countries();
        Assert.assertNotNull(countries);
    }
}