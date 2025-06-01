package org.trader.backdemo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.trader.backdemo.models.Feature;
@Data
@Builder

public class FeatureResponse {

    @JsonProperty("features")
    Feature[] features;
}
