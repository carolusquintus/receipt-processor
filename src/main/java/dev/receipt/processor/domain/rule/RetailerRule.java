package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.util.regex.Pattern;

@Bean
@Named("retailerRule")
public class RetailerRule implements Rule<String> {

    @Override
    public Long process(String retailer) {
        return Pattern
            .compile("[a-zA-Z0-9]")
            .matcher(retailer)
            .results()
            .count();
    }

}
