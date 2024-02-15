package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.FakeStoreCartRequestModelPost;
import util.Configuration;

public class FakeStoreCartClient {
    public Response postCart(FakeStoreCartRequestModelPost request){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.CART_POST_URL)
                .thenReturn();
    }
}
