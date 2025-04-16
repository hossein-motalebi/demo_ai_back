package org.trader.backdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trader.backdemo.service.AgentService;
import org.trader.backdemo.dto.response.*;

@RestController

@CrossOrigin("*")
@RequestMapping("/")
public class AgentController {

    private final AgentService agentService;


    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/features")
    public FeatureResponse getFeatures(){
        return agentService.getFeatures();
    }

}
