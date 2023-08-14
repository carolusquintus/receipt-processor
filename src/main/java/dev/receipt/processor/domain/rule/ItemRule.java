package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.entity.Item;
import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

import java.math.BigDecimal;

import static java.math.RoundingMode.UP;

@Bean
@Named("itemRule")
public class ItemRule implements Rule<Item> {

    @Override
    public Long process(Item item) {
        var descriptionLength = item.shortDescription().trim().length();

        if (descriptionLength % 3 == 0) {
            return item
                .price().multiply(new BigDecimal("0.2"))
                .setScale(0, UP).longValue();
        }

        return 0L;
    }

}
