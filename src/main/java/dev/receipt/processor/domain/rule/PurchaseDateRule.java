package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.time.LocalDate;
import java.util.Objects;

import static java.util.Objects.isNull;

@Bean
@Named("purchaseDateRule")
public class PurchaseDateRule implements Rule<LocalDate> {

    @Override
    public Long process(LocalDate purchaseDate) {
        if (isNull(purchaseDate)) {
            return 0L;
        }
        var day = purchaseDate.getDayOfMonth();
        return (day % 2 == 0) ? 0L : 6L;
    }

}
