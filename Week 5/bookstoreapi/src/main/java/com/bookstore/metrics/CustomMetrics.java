package com.bookstore.metrics;


import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final MeterRegistry meterRegistry;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Counted(value = "custom.metrics.count", description = "Number of custom metrics increments")
    public void incrementCustomMetric() {
        meterRegistry.counter("custom.metrics.count").increment();
    }

    @Timed(value = "custom.metrics.timing", description = "Time taken to process custom metrics")
    public void timedCustomMetric() {
        // Add logic here that you want to time
    }
}
