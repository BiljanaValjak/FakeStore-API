package models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreCartRequestModelPostPut {

    String userId;
    String date;
    List<FakeStoreCartRequestModelProductsPostPut> products;




}
