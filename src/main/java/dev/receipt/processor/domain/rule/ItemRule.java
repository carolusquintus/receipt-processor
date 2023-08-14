package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.entity.Item;
import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;

@Bean
@Named("itemRule")
public class ItemRule implements Rule<Item> {

    @Override
    public Long process(Item item) {
        return 600L;
    }

}
