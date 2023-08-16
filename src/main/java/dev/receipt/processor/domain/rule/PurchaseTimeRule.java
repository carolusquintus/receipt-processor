package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.time.LocalTime;
import java.util.Objects;

import static java.util.Objects.isNull;

@Bean
@Named("purchaseTimeRule")
public class PurchaseTimeRule implements Rule<LocalTime> {

    @Override
    public Long process(LocalTime purchaseTime) {
        if (isNull(purchaseTime)) {
            return 0L;
        }
        return (purchaseTime.isAfter(LocalTime.of(14, 0)) &&
                purchaseTime.isBefore(LocalTime.of(16, 0)))
            ? 10L
            : 0L;
    }

}
