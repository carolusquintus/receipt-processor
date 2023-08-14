package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.RoundingMode.HALF_UP;

@Bean
@Named("totalRule")
public class TotalRule implements Rule<BigDecimal> {

    @Override
    public Long process(BigDecimal total) {
        long sum = 0L;

        total = total.setScale(2, HALF_UP);
        var fraction = total.remainder(ONE);
        var fractionAsInt = fraction.multiply(new BigDecimal(100)).intValue();

        if (new BigDecimal("0.00").equals(fraction)) {
            sum += 50L;
        }

        if (fractionAsInt % 25 == 0) {
            sum += 25L;
        }

        return sum;
    }

}
