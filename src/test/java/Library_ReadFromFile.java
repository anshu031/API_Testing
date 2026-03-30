import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Library_ReadFromFile {

    @Test
    public void AddBook() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String path="D:\\payload.txt" ;
        given().log().all().contentType("application/json").
                body(readFile(path))
                .when().post("Library/Addbook.php")
                .then().log().all().statusCode(200);


    }


    public String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));

    }


}



