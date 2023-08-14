package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

@Bean
@Named("retailerRule")
public class RetailerRule implements Rule<String> {

    @Override
    public Long process(String retailer) {
        return 100L;
    }

}
