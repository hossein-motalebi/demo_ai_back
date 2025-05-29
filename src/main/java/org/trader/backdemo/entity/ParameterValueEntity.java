package org.trader.backdemo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "parameter_value")

public class ParameterValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parameter_value_id")
    private Long id;

    private String value;

    @ManyToOne
    @JoinColumn(name = "agent_feature_id")
    private AgentFeatureEntity agentFeature;

    @ManyToOne
    @JoinColumn(name = "parametre_definition_id")
    private ParametreDefinitionEntity parametreDefinition;



}
