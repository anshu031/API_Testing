import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Practise2 {

    public static void main(String[] args){


        RestAssured.baseURI="https://rahulshettyacademy.com/";
        String response=given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("server","Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();

      //  System.out.println(response);

        //parse json
        JsonPath js=new JsonPath(response);
        String placeId=js.getString("place_id");
       // System.out.println(placeId);

        //update place

        given().queryParam("place_id",placeId).queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\"70333 winter walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")

                .when().put("maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200);





        //get place
        given().queryParam("place_id",placeId).queryParam("key","qaclick123").header("Content-Type","application/json")
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200);


    }

}
