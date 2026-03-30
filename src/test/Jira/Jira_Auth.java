import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static io.restassured.RestAssured.*;

public class Jira_Auth {

<<<<<<< HEAD

=======
    String key="checkgitignore";
>>>>>>> ddb0f7f15db37ad9fedfdb3485614c28fdfd8678
    @Test
    public void createBug() throws InterruptedException {

        RestAssured.baseURI="https://anshuman31.atlassian.net/";


<<<<<<< HEAD
String key="a";
=======

>>>>>>> ddb0f7f15db37ad9fedfdb3485614c28fdfd8678

        Response res=  given().log().all()
                    .auth()
                    .preemptive()
                    .basic("anshumandubeyanshu@gmail.com", key)
                    .contentType(ContentType.JSON)
                 .body("{\n" +
                         "    \"fields\": {\n" +
                         "        \"project\": {\n" +
                         "            \"key\": \"TES\"\n" +
                         "        },\n" +
                         "        \"summary\": \"Main order button is not responding on mobile\",\n" +
                         "        \"description\": {\n" +
                         "            \"type\": \"doc\",\n" +
                         "            \"version\": 1,\n" +
                         "            \"content\": [\n" +
                         "                {\n" +
                         "                    \"type\": \"paragraph\",\n" +
                         "                    \"content\": [\n" +
                         "                        {\n" +
                         "                            \"text\": \"Steps to reproduce: 1. Open app... 2. Click button...\",\n" +
                         "                            \"type\": \"text\"\n" +
                         "                        }\n" +
                         "                    ]\n" +
                         "                }\n" +
                         "            ]\n" +
                         "        },\n" +
                         "        \"issuetype\": {\n" +
                         "            \"name\": \"Bug\"\n" +
                         "        }\n" +
                         "    }\n" +
                         "}").
                when().post("rest/api/3/issue")
                .then().assertThat().statusCode(201).extract().response();





        String ids=res.path("id");

        given().pathParam("id",ids).
                header("X-Atlassian-Token","no-check").
                auth().preemptive().
                basic("anshumandubeyanshu@gmail.com", key).
                multiPart("file",new File("C:\\Users\\anshu\\Downloads\\IMG_2388.PNG")).

                when().
                post("rest/api/3/issue/{id}/attachments").
                then().log().all().assertThat().statusCode(200);
    }

}


