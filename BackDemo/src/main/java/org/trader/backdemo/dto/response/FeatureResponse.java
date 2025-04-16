package org.trader.backdemo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.trader.backdemo.models.Feature;
@Data

public class FeatureResponse {

    @JsonProperty("features")
    Feature[] features;
}
