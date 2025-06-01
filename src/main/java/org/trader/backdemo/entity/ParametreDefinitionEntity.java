package org.trader.backdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "parametre_definition")

public class ParametreDefinitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parametre_definition_id")
    private Long id;

    private String name;

    private String defaultValue;

    @Enumerated(EnumType.STRING)
    private ParametreTypeEnum type;

    private boolean required;
    @OneToMany(mappedBy = "parametreDefinition", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParameterValueEntity> parameterValues = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "feature_id")
    private FeatureEntity feature;

    public enum ParametreTypeEnum{
        INTEGER,
        DOUBLE,
        STRING,
        BOOLEAN,
        DATE
    }





}
