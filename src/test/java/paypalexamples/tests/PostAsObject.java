package paypalexamples.tests;

import com.paypalexamples.payment.pojo.*;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostAsObject extends BaseClass {

    static String paymentId;

    @Test
    public void createAPayment() {

        Redirect_urls redirectUrls = new Redirect_urls();
        redirectUrls.setCancel_url("http://www.hawaii.com");
        redirectUrls.setReturn_url("http://www.amazon.com");
        Details details = new Details();
        details.setHandling_fee("1.00");
        details.setInsurance("0.01");
        details.setShipping("0.03");
        details.setShipping_discount("-1.00");
        details.setSubtotal("30.00");
        details.setTax("0.07");

        //creating Amount
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setDetails(details);
        amount.setTotal("30.11");

        //Setting the shipping address
        Shipping_address shippingAddress = new Shipping_address();
        shippingAddress.setCity("San Hose");
        shippingAddress.setCountry_code("US");
        shippingAddress.setLine1("4thFloor");
        shippingAddress.setLine2("unit34");
        shippingAddress.setPhone("011238745643256894");
        shippingAddress.setPostal_code("02453");
        shippingAddress.setRecipient_name("Jack");
        shippingAddress.setState("CA");

        //Set the items
        Items item = new Items();
        item.setCurrency("USD");
        item.setDescription("Brown color hat");
        item.setName("hat");
        item.setPrice("3");
        item.setQuantity("5");
        item.setSku("1");
        item.setTax("0.01");

        Items item2 = new Items();
        item2.setCurrency("USD");
        item2.setDescription("Black color hand bag");
        item2.setName("handbag");
        item2.setPrice("15");
        item2.setQuantity("1");
        item2.setSku("product33");
        item2.setTax("0.02");

        List<Items> items = new ArrayList<>();
        items.add(item);
        items.add(item2);

        //setting the item_list
        Item_list itemList = new Item_list();
        itemList.setShipping_address(shippingAddress);
        itemList.setItems(items);

        //Setting the payment options
        PaymentOptions paymentOptions = new PaymentOptions();
        paymentOptions.setAllowed_payment_options("INSTANT_FUNDING_SOURCE");

        //Setting the transactions
        Transactions transaction = new Transactions();
        transaction.setAmount(amount);
        transaction.setCustom("EBAY_EMS");
        transaction.setDescription("This is a test transaction");
        transaction.setInvoice_number("234535687");
        transaction.setItem_list(itemList);
        transaction.setPaymentOptions(paymentOptions);
        transaction.setSoft_descriptor("ECH4835853");

        List<Transactions> transactions = new ArrayList<>();
        transactions.add(transaction);

        //Setting the Payer
        Payer payer = new Payer();
        payer.setPayment_method("paypal");

        PostObj postObj = new PostObj();
        postObj.setIntent("sale");
        postObj.setNote_to_payer("Contact us");
        postObj.setRedirect_urls(redirectUrls);
        postObj.setPayer(payer);
        postObj.setTransactions(transactions);

        paymentId = given().contentType(ContentType.JSON)
                .auth()
                .oauth2(accessToken)
                .when()
                .body(postObj)
                .post("payments/payment")
                .then()
                .extract()
                .path("id");
    }

    @Test
    public void getPaymentDetails() {
        given()
                .auth()
                .oauth2(accessToken)
                .when()
                .get("payments/payment/" + paymentId)
                .then()
                .log()
                .all();
    }
}
