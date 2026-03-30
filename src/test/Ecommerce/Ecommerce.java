import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Ecommerce {

    public static void main(String[] args){

        LoginPojo lp=new LoginPojo();
        lp.setUserEmail("testuser313@gmail.com");
        lp.setUserPassword("Password@1");
        RequestSpecification rs=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();

        RequestSpecification rsLogin=given().log().all().spec(rs).body(lp);

       LoginResponsePojo lr= rsLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponsePojo.class);
      String token=lr.getToken();
      String userId=lr.getUserId();


        RequestSpecification addProductBase=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
                addHeader("authorization",token).
                build();

             RequestSpecification addProduct= given().log().all().spec(addProductBase).param("productName","Laptop3")
                            .param("productAddedBy",userId)
                            .param("productCategory","Electronics")
                            .param("productSubCategory","appliances")
                            .param("productPrice","999")
                            .param("productDescription","Asus")
                            .param("productFor","men")
                            .multiPart("productImage",new File("C:\\Users\\anshu\\Downloads\\testing.png"));

          String addProductResponse=   addProduct.when().post("/api/ecom/product/add-product").then().log().all().extract().response().asString();

        JsonPath js=new JsonPath(addProductResponse);
        String productId=js.get("productId");

        //create order
        OrderDetailPojo odp=new OrderDetailPojo();
        odp.setCountry("India");
        odp.setProductOrderedId(productId);
        List <OrderDetailPojo> li=new ArrayList<OrderDetailPojo>();
                li.add(odp);

        OrderPojo pj=new OrderPojo();
        pj.setOrders(li);

        RequestSpecification createOrder=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
                addHeader("authorization",token).setContentType(ContentType.JSON).
                build();

       RequestSpecification createOrderReq= given().log().all().spec(createOrder).body(pj);

       createOrderReq.when().post("/api/ecom/order/create-order").then().log().all();



       //delete
        RequestSpecification deleteProduct=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
                addHeader("authorization",token).setContentType(ContentType.JSON).
                build();

        given().log().all().spec(deleteProduct).pathParam("productId",productId).
                when().delete("/api/ecom/product/delete-product/{productId}").
                then().log().all();
    }

}
