package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.time.LocalTime;

@Bean
@Named("purchaseTimeRule")
public class PurchaseTimeRule implements Rule<LocalTime> {

    @Override
    public Long process(LocalTime purchaseTime) {
        return (purchaseTime.isAfter(LocalTime.of(14, 0)) &&
                purchaseTime.isBefore(LocalTime.of(16, 0)))
            ? 10L
            : 0L;
    }

}
