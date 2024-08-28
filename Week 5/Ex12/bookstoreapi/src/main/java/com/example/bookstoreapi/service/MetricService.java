package com.example.bookstoreapi.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricService {

    private final MeterRegistry meterRegistry;

    public MetricService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        initializeMetrics();
    }

    private void initializeMetrics() {
        meterRegistry.gauge("custom_metric_total", 100); // Example metric
    }

    public void incrementCustomMetric() {
        meterRegistry.counter("custom_metric_total").increment();
    }
}
