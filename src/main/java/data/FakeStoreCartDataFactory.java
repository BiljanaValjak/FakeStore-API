package data;

import models.request.FakeStoreCartRequestModelPost;

public class FakeStoreCartDataFactory {
    private FakeStoreCartRequestModelPost request;

    public FakeStoreCartDataFactory(FakeStoreCartRequestModelPost requestBody){
        request = requestBody;
    }
    public FakeStoreCartDataFactory setUserId(String value){
        request.setUserId(value);
        return this;
    }
    public FakeStoreCartDataFactory setDate(String value){
        request.setDate(value);
        return this;
    }
    public FakeStoreCartDataFactory setProductId(int value){
        request.getProducts().setProductId(value);
        return this;
    }
    public FakeStoreCartDataFactory setQuantity(int value){
        request.getProducts().setQuantity(value);
        return this;
    }
    public FakeStoreCartRequestModelPost createBody(){
        return request;
    }
}
