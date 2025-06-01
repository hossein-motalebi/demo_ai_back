package org.trader.backdemo.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.trader.backdemo.entity.FeatureEntity;
import org.trader.backdemo.entity.ParametreDefinitionEntity;
import org.trader.backdemo.models.Feature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface FeatureEntityMapper {

    @Mapping(source = "parametreDefinitions", target = "parameters", qualifiedByName = "toParametersMap")
    Feature toFeature(FeatureEntity featureEntity);

    @Named("toParametersMap")
    default Map<String, String> toParametersMap(Set<ParametreDefinitionEntity> paramDefs) {
        Map<String, String> params = new HashMap<>();
        if (paramDefs == null) {
            return params;
        }
        for (ParametreDefinitionEntity def : paramDefs) {
            params.put(def.getName(), def.getDefaultValue());
        }
        return params;
    }
}
