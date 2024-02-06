package mother;

import models.request.FakeStoreCartRequestModelPost;
import models.request.FakeStoreCartRequestModelProductsPost;

public class FakeStoreCartMother {
    public static FakeStoreCartRequestModelPost createBodyForProduct(){
        return FakeStoreCartRequestModelPost.builder()
                .userId("Default userId")
                .date("Default date")
                .products(FakeStoreCartRequestModelProductsPost.builder()
                        .productId(0)
                        .quantity(0)
                        .build())
                .build();
    }
}

