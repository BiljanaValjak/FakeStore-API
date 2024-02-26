package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.FakeStoreCartRequestModelPostPut;
import util.Configuration;

public class FakeStoreCartClient {
    public Response getAllCarts(){
        return RestAssured.given()
                .when().log().all()
                .get(Configuration.CART_GETALL_URL)
                .thenReturn();
    }
    public Response getCartByUser(String userId){
        return RestAssured.given()
                .when().log().all()
                .get(Configuration.CART_GETBYUSER_URL + "/" + userId)
                .thenReturn();
    }
    public Response postCart(FakeStoreCartRequestModelPostPut request){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.CART_POST_URL)
                .thenReturn();
    }
    public Response updateCart(FakeStoreCartRequestModelPostPut request, String id){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(Configuration.CART_PUT_URL + "/" + id)
                .thenReturn();
    }
    public Response deleteCartByUser(String id){
        return RestAssured.given()
                .when().log().all()
                .delete(Configuration.CART_DELETE_URL + "/" + id)
                .thenReturn();
    }
}
