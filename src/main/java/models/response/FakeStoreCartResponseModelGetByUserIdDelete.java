package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreCartResponseModelGetByUserIdDelete {

    int id;
    int userId;
    String date;
    List<FakeStoreCartResponseModelProductsGetByUserIdDelete> products;
    int __v;
}
