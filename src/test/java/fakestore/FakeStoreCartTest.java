package fakestore;

import client.FakeStoreCartClient;
import data.FakeStoreCartDataFactoryPost;
import data.FakeStoryCartDataFactoryPut;
import io.restassured.response.Response;
import models.request.FakeStoreCartRequestModelPostPut;
import models.response.*;
import org.junit.Test;

import java.util.List;

import static mother.FakeStoreCartMother.createBodyForPost;
import static mother.FakeStoreCartMother.createBodyForPut;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FakeStoreCartTest {
    @Test
    public void getAllCartsFakeStoreTest(){

        Response getresponse = new FakeStoreCartClient()
                .getAllCarts();
        List<FakeStoreCartResponseModelGETAll> fakeStoreResponse = getresponse
                .body()
                .jsonPath()
                .getList("", FakeStoreCartResponseModelGETAll.class);

        assertEquals(200, getresponse.statusCode());
        assertFalse(fakeStoreResponse.isEmpty());

    }
    @Test
    public void getCartByUserFakeStoreTest(){

        Response getUserResponse = new FakeStoreCartClient()
                .getCartByUser("2");

        List<FakeStoreCartResponseModelGetByUserIdDelete> fakeStoreResponse = getUserResponse
                .body()
                .jsonPath()
                .getList("", FakeStoreCartResponseModelGetByUserIdDelete.class);

        FakeStoreCartResponseModelGetByUserIdDelete userCartResponse = fakeStoreResponse.get(0);
        assertEquals(200,getUserResponse.statusCode());
        assertEquals(3, userCartResponse.getId());
        assertEquals(2, userCartResponse.getUserId());
        assertEquals("2020-03-01T00:00:00.000Z", userCartResponse.getDate());
        assertEquals(0,userCartResponse.get__v());
        assertFalse(fakeStoreResponse.isEmpty());

        FakeStoreCartResponseModelProductsGetByUserIdDelete product1 = userCartResponse.getProducts().get(0);
        assertEquals(1, product1.getProductId());
        assertEquals(2, product1.getQuantity());

        FakeStoreCartResponseModelProductsGetByUserIdDelete product2 = userCartResponse.getProducts().get(1);
        assertEquals(9, product2.getProductId());
        assertEquals(1, product2.getQuantity());

    }
    @Test
    public void postNewCartFakeStoreDefaultValuesTest(){

        FakeStoreCartRequestModelPostPut request =  new FakeStoreCartDataFactoryPost(createBodyForPost())
                .createBody();

        Response postResponse = new FakeStoreCartClient()
                .postCart(request);

        FakeStoreCartResponseModelPostPut response = postResponse.body().as(FakeStoreCartResponseModelPostPut.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("Default userId", response.getUserId() );
        assertEquals("Default date", response.getDate());

    }
    @Test
    public void postNewCartFakeStoreTest(){
        String userId = "5";

        FakeStoreCartRequestModelPostPut request =  new FakeStoreCartDataFactoryPost(createBodyForPost())
                .setUserId(userId)
                .setDate("2020-02-03")
                .setProducts(5,1,1,5)
                .createBody();

        Response postResponse = new FakeStoreCartClient()
                .postCart(request);

        FakeStoreCartResponseModelPostPut response = postResponse.body().as(FakeStoreCartResponseModelPostPut.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals(userId, response.getUserId());
        assertEquals("2020-02-03", response.getDate());
        assertFalse(response.getProducts().isEmpty());

    }
    @Test
    public void putNewCartFakeStoreTest(){
        String id = "7";

        FakeStoreCartRequestModelPostPut request =  new FakeStoryCartDataFactoryPut(createBodyForPut())
                .setUserId(id)
                .setDate("2019-12-10")
                .setProducts(1,3)
                .createBody();

        Response postResponse = new FakeStoreCartClient()
                .updateCart(request, id);

        FakeStoreCartResponseModelPostPut response = postResponse.body().as(FakeStoreCartResponseModelPostPut.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals(id, response.getUserId());
        assertEquals("2019-12-10", response.getDate());
        assertFalse(response.getProducts().isEmpty());

    }
    @Test
    public void deleteEmployeeTest(){
        String id = "6";
        int userId = Integer.parseInt("6");

        Response deleteCart = new FakeStoreCartClient()
                .deleteCartByUser(id);

        FakeStoreCartResponseModelGetByUserIdDelete cartResponse = deleteCart.body().as(FakeStoreCartResponseModelGetByUserIdDelete.class);

        assertEquals(200, deleteCart.statusCode());
        assertEquals(userId, cartResponse.getId());

    }

}
