package tests;

import api.Authorization;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemoWebShopTest extends TestBase {
    String body = "product_attribute_80_2_37=112&product_attribute_80_1_38=114&addtocart_80.EnteredQuantity=1",
    content = "application/x-www-form-urlencoded; charset=UTF-8";

    @Test
    void addedToWishListTest() {
        Response response =
                given()
                        .contentType(content)
                        .cookie("__utmz=78382081.1617052352.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); nop.CompareProducts=; ARRAffinity=1fa9158750fcf7cee1728ac683a12594fe016bf3b1c0544237f51a4ffe2ef5ea; __utma=78382081.304793805.1617052352.1617052352.1617095477.2; __utmc=78382081; ASP.NET_SessionId=44gvjaxllyqmxrkwk4rrs40y; _gcl_au=1.1.1753010315.1617098077; _gid=GA1.2.1589210618.1617098077; _mkto_trk=id:470-GZN-442&token:_mch-tricentis.com-1617098077416-19786; _ga=GA1.2.1739832809.1617098077; _ga_489D1QT6C1=GS1.1.1617098077.1.1.1617098204.0; NOPCOMMERCE.AUTH=FC6491E977A037AAA4EBA09B831860A92C177FE926E6BC842CFCBC6F5E88EC6B7498F8A5BEFC812200368DEAEC8A18E3AF1987A02556BC0C9F4314D21F87F7C3FACC4541DCC576A7E2C4DD2C642F0A4F0FA9F3565359AAF59F7811E3AB7ECB966CC2C78C0DBA8ADCDFF911A6C1381A3DDC7706BF04A7A5EF1A9C17B2343CF70CACF60A1ABEC20F5898836D4FAB220E48C38BDC2096B1EC7E21CE648510BA857C; Nop.customer=42f5e14c-46ad-4629-beb2-605c6fc6a47c; __RequestVerificationToken=o8DjQJTc_CsHauNSlOmVSj2KV5UlnwSGZmFzvn_tR-ZvawOuFE-zm6z4UCbck8XNtT55rSRCF6DV4jieKtae3rdf75X3mcnkQppcHqS0lWA1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=80&RecentlyViewedProductIds=2&RecentlyViewedProductIds=44&RecentlyViewedProductIds=71; __utmt=1; __atuvc=16%7C13; __atuvs=6062f6d681415ad7006; __utmb=78382081.68.10.1617095477")
                        .body(body)
                        .when()
                        .post("/addproducttocart/details/80/2")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .body("success", is(true))
                        .extract().response();

        System.out.println(response);
    }

    @Test
    void addedToWishListWithCookieTest() {
        Map<String, String> cookies = new Authorization().login("bkuchaev@gmail.com", "43315231");

        Response response =
                given()
                        .contentType(content)
                        .cookies(cookies)
                        .body(body)
                        .when()
                        .post("/addproducttocart/details/80/2")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .body("success", is(true))
                        .extract().response();

        System.out.println(response);
    }

}
