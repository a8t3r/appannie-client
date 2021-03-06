# Appannie java client

Java client for appannie [rest api v1.2](https://support.appannie.com/hc/en-us/categories/200261564-Analytics-API-v1-2-).
Implemented over [feign library](https://github.com/Netflix/feign)

## Supported methods:
* Data APIs
 * Account Connection Sales
 * Product Details
 * Product Sales
 * Product Ranks
 * Product Features
 * Product Reviews
 * Product Ratings
 * User Advertising Sales
* Meta Data API
 * Country List
 * Category List
 * Market List
 * Currency List
 * Device List
 * Feed List
 * Translate from code to production ID
* Account APIs
 * Account Connections List
 * Account Connection Product List
 * Shared Products List

## Examples

```java
AppannieClient client = new AppannieClient("YOUR-TOKEN");
Accounts accounts = client.accounts();
int pageNum = 0;
AccountResponse accountList = accounts.accounts(pageNum);
Assert.assertNotNull(accountList);

Account account = accountList.accounts.iterator().next();
AccountProductResponse productList = accounts.accountProducts(account.accountId, pageNum);
Assert.assertNotNull(productList);
```