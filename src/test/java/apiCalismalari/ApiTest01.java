package apiCalismalari;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;//response için
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ApiTest01 {

    /*
          https://jsonplaceholder.typicode.com/posts/44 url'ine bir
        GET request yolladigimizda donen Response' in
        status code'unun 200,
        ve content type'inin JSON,
        ve response body'sinde bulunan userId'nin 5,
        ve response body'sinde bulunan title'in "optio dolor molestias sit"
        oldugunu test edin. */

    @Test
    public void test01() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        //expected daha oluşturulur
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", 1);
        jsonObject.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        //responsu kaydetmek için

        //json objesi üreterek karşılaştırma işlemi yapıcaz

        Response response = given().when().get(url);
        //Assertion
        // response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonObject.get("userId"), jsonPath.get("userId"));
        Assert.assertEquals(jsonObject.get("title"), jsonPath.get("title"));
    }

    @Test
    public void test02() {

        String url = "https://jsonplaceholder.typicode.com/posts/2";

        JSONObject myjsonObject = new JSONObject();
        myjsonObject.put("userId", 1);
        myjsonObject.put("title", "qui est esse");

        Response response = given().when().get(url);

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();

        Assert.assertEquals(myjsonObject.get("userId"), jsonPath.get("userId"));
        Assert.assertEquals(myjsonObject.get("title"), jsonPath.get("title"));


    }
    //deneme01

}
