package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.service.MetricService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    private final MetricService metricService;

    public MetricsController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping("/increment")
    public String incrementMetric() {
        metricService.incrementCustomMetric();
        return "Custom metric incremented";
    }
}
