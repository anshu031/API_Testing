import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Library_DataProvider {


    @Test(dataProvider = "BooksData")
    public void addBook(String isbn,String aisle){
        RestAssured.baseURI="http://216.10.245.166";

        String s=  given().body(files.payload.addBook(isbn,aisle)).when()
                .post("Library/Addbook.php")
                .then().log().all().extract().response().asString();

        JsonPath js=new JsonPath(s);
        String id=js.getString("ID");
        System.out.println(id);

    }
    @DataProvider(name="BooksData")
    public Object[][] getData(){
      return new Object[][] {
              {"arr1","arr2"},
            {"arr3","arr4"}};
    }




}

