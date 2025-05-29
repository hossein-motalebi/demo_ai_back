package org.trader.backdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Table(name="agent")

public class AgentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name= "target_market")
    private String targetMarket;

    @Column(name="input_start_time")
    private Timestamp inputStartTime;

    @Column(name="input_end_time")
    private Timestamp inputEndTime;

    @Column(name="input_frequency")
    private int inputFrequency;

    @Column(name="output_start_time")
    private Timestamp outputStartTime;

    @Column(name="output_end_time")
    private Timestamp outputEndTime;

    @Column(name="output_frequency")
    private int outputFrequency;

    @Column(name="is_trained")
    private boolean isTrained;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AgentFeatureEntity> agentFeatures;


}
