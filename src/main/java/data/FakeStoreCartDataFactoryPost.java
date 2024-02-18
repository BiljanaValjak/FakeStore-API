package data;

import models.request.FakeStoreCartRequestModelPostPut;
import models.request.FakeStoreCartRequestModelProductsPostPut;

import java.util.ArrayList;
import java.util.List;

public class FakeStoreCartDataFactoryPost {
    private FakeStoreCartRequestModelPostPut request;

    public FakeStoreCartDataFactoryPost(FakeStoreCartRequestModelPostPut requestBody){
        request = requestBody;
    }
    public FakeStoreCartDataFactoryPost setUserId(String value){
        request.setUserId(value);
        return this;
    }
    public FakeStoreCartDataFactoryPost setDate(String value){
        request.setDate(value);
        return this;
    }
    public FakeStoreCartDataFactoryPost setProducts(int value1, int value2, int value3, int value4) {
        List<FakeStoreCartRequestModelProductsPostPut> products = new ArrayList<>();

        FakeStoreCartRequestModelProductsPostPut product1 = new FakeStoreCartRequestModelProductsPostPut();
        product1.setProductId(value1);
        product1.setQuantity(value2);

        FakeStoreCartRequestModelProductsPostPut product2 = new FakeStoreCartRequestModelProductsPostPut();
        product2.setProductId(value3);
        product2.setQuantity(value4);

        products.add(product1);
        products.add(product2);

        request.setProducts(products);
        return this;
    }

    public FakeStoreCartRequestModelPostPut createBody(){
        return request;
    }
}
