package ru.effector.responses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.effector.model.Device;
import ru.effector.model.ProductRank;
import ru.effector.utils.deserializers.DateKeyDeserializer;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Alexandr Kolosov
 * @since 06.08.2015
 */
public class ProductRanksResponse extends PageableResponse {

    public String productName;
    public Device device;

    @JsonDeserialize(contentUsing = DateKeyDeserializer.class)
    public Map<String, Date> updateTime;
    public List<ProductRank> productRanks;

}
