package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.time.LocalTime;

@Bean
@Named("purchaseTimeRule")
public class PurchaseTimeRule implements Rule<LocalTime> {

    @Override
    public Long process(LocalTime localTime) {
        return 300L;
    }

}
