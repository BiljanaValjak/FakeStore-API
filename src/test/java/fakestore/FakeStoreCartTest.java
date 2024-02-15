package fakestore;

import client.FakeStoreCartClient;
import data.FakeStoreCartDataFactory;
import io.restassured.response.Response;
import models.request.FakeStoreCartRequestModelPost;
import models.response.FakeStoreCartResponseModelPost;
import org.junit.Test;

import static mother.FakeStoreCartMother.createBodyForProduct;
import static org.junit.Assert.assertEquals;

public class FakeStoreCartTest {
    @Test
    public void fakeStoreDefaultValuesPostTest(){

        FakeStoreCartRequestModelPost request = new FakeStoreCartDataFactory(createBodyForProduct())
                .createBody();

        Response postResponse = new FakeStoreCartClient()
                .postCart(request);

        FakeStoreCartResponseModelPost response = postResponse.body().as(FakeStoreCartResponseModelPost.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("Default userId", response.getUserId() );
        assertEquals("Default date", response.getDate());
        assertEquals(0, response.getProducts().getProductId());
        assertEquals(0, response.getProducts().getQuantity());

    }
    @Test
    public void fakeStorePostTest(){

        FakeStoreCartRequestModelPost request = new FakeStoreCartDataFactory(createBodyForProduct())
                .setUserId("21")
                .setDate("2020-02-03")
                .setProductId(5)
                .setQuantity(1)
                .createBody();

        Response postResponse = new FakeStoreCartClient()
                .postCart(request);


        FakeStoreCartResponseModelPost response = postResponse.body().as(FakeStoreCartResponseModelPost.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("21", response.getUserId() );
        assertEquals("2020-02-03", response.getDate());
        assertEquals(5, response.getProducts().getProductId());
        assertEquals(1, response.getProducts().getQuantity());

    }

}
