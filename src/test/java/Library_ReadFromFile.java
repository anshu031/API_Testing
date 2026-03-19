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
        given().
                body(readFile(path))
                .post("Library/Addbook.php")
                .then().log().all();


    }


    public byte[] readFile(String path) throws IOException {
        return (Files.readAllBytes(Paths.get(path)));

    }


}




