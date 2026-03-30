import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Library {

    @Test
    public void addBook(){
        RestAssured.baseURI="http://216.10.245.166";

      String s=  given().body(files.payload.addBook("abcdanshu","1234")).when()
                .post("Library/Addbook.php")
                .then().log().all().extract().response().asString();

        JsonPath js=new JsonPath(s);
        String id=js.getString("ID");
        System.out.println(id);

    }
}

