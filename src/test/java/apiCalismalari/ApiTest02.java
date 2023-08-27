package apiCalismalari;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;//response için
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ApiTest02 {

    @Test
    public void test02() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject postolan = new JSONObject();
        postolan.put("title", " title degıstırme post ile");
        postolan.put("body", "bilal deneme body degıstırme");
        postolan.put("userId", "10");

        //beklenilen cevabı da yazıyoruz
        JSONObject responsObject = new JSONObject();
        responsObject.put("title", " title degıstırme post ile");
        responsObject.put("body", "bilal deneme body degıstırme");
        responsObject.put("userId", "10");

        Response response = given().contentType(ContentType.JSON).when().body(postolan.toString()).post(url);//Gonderecegımız veriyi buraya yazıyoruz

        JsonPath responsunJsonPathFormatliHali = response.jsonPath();

        Assert.assertEquals(responsObject.get("title"), responsunJsonPathFormatliHali.get("title"));
        Assert.assertEquals(responsObject.get("body"), responsunJsonPathFormatliHali.get("body"));
        Assert.assertEquals(responsObject.get("userId"), responsunJsonPathFormatliHali.get("userId"));
    }


    @Test
    public void test03() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        //Güncelleyeceğimiz objeyi json formatında yazarız
        JSONObject myjson = new JSONObject();
        myjson.put("title", "title Bilal");
        myjson.put("userId", "17");
        myjson.put("body", "body Bilal");

        JSONObject responseBeklenilenObje = new JSONObject();
        responseBeklenilenObje.put("title", "title Bilal");
        responseBeklenilenObje.put("userId", "17");
        responseBeklenilenObje.put("body", "body Bilal");

        Response response = given().contentType(ContentType.JSON).when().body(myjson.toString()).post(url);
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(myjson.get("title"), jsonPath.get("title"));
        Assert.assertEquals(myjson.get("title"), jsonPath.get("title"));
        Assert.assertEquals(myjson.get("userId"), jsonPath.get("userId"));


    }

}
