package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

@Bean
@Named("retailerRule")
public class RetailerRule implements Rule<String> {

    @Override
    public Long process(String retailer) {
        if (isNull(retailer)) {
            return 0L;
        }
        return Pattern
            .compile("[a-zA-Z0-9]")
            .matcher(retailer)
            .results()
            .count();
    }

}
