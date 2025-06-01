package org.trader.backdemo.controller;

import org.springframework.web.bind.annotation.*;
import org.trader.backdemo.service.FeatureService;
import org.trader.backdemo.dto.response.*;

@RestController

@CrossOrigin("*")
@RequestMapping("/api")
public class AgentController {

    private final FeatureService agentService;


    public AgentController(FeatureService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/features")
    public FeatureResponse getFeatures(){
        return agentService.getFeatures();
    }

}
