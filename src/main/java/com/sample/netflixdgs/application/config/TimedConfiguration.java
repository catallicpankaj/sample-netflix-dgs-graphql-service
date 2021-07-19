package com.sample.netflixdgs.application.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimedConfiguration {
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        registry.config().commonTags("application","SampleNetflixDgsGraphQLApplication");
        return new TimedAspect(registry);
    }
}
