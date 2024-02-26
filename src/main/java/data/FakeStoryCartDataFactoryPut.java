package data;

import models.request.FakeStoreCartRequestModelPostPut;
import models.request.FakeStoreCartRequestModelProductsPostPut;

import java.util.ArrayList;
import java.util.List;

public class FakeStoryCartDataFactoryPut {
    private FakeStoreCartRequestModelPostPut request;

    public FakeStoryCartDataFactoryPut(FakeStoreCartRequestModelPostPut requestBody){
        request = requestBody;
    }
    public FakeStoryCartDataFactoryPut setUserId(String value){
        request.setUserId(value);
        return this;
    }
    public FakeStoryCartDataFactoryPut setDate(String value){
        request.setDate(value);
        return this;
    }
    public FakeStoryCartDataFactoryPut setProducts(int value1, int value2) {
        List<FakeStoreCartRequestModelProductsPostPut> products = new ArrayList<>();

        FakeStoreCartRequestModelProductsPostPut product = new FakeStoreCartRequestModelProductsPostPut();
        product.setProductId(value1);
        product.setQuantity(value2);

        products.add(product);

        request.setProducts(products);
        return this;
    }
    public FakeStoreCartRequestModelPostPut createBody(){
        return request;
    }
}

