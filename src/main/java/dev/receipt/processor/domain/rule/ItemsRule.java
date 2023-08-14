package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.entity.Item;
import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Bean
@Named("itemsRule")
@RequiredArgsConstructor
public class ItemsRule implements Rule<List<Item>> {

    private final Rule<Item> itemRule;

    @Override
    public Long process(List<Item> items) {
        return 500L;
    }

}
