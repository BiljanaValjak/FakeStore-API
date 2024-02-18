package mother;

import models.request.FakeStoreCartRequestModelPostPut;
import models.request.FakeStoreCartRequestModelProductsPostPut;

import java.util.List;


public class FakeStoreCartMother {
    public static FakeStoreCartRequestModelPostPut createBodyForPost() {
        return FakeStoreCartRequestModelPostPut.builder()
                .userId("Default userId")
                .date("Default date")
                .products(List.of(
                        FakeStoreCartRequestModelProductsPostPut.builder()
                                .productId(0)
                                .quantity(0)
                                .build(),
                        FakeStoreCartRequestModelProductsPostPut.builder()
                                .productId(0)
                                .quantity(0)
                                .build()
                ))
                .build();
    }
    public static FakeStoreCartRequestModelPostPut createBodyForPut() {
        return FakeStoreCartRequestModelPostPut.builder()
                .userId("Default userId")
                .date("Default date")
                .products(List.of(
                        FakeStoreCartRequestModelProductsPostPut.builder()
                                .productId(0)
                                .quantity(0)
                                .build()
                ))
                .build();
    }
}

