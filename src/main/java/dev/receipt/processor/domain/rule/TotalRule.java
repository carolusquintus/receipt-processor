package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.math.BigDecimal;

@Bean
@Named("totalRule")
public class TotalRule implements Rule<BigDecimal> {

    @Override
    public Long process(BigDecimal total) {
        return 0L;
    }

}
