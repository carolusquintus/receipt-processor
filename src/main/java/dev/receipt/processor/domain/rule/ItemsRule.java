package dev.receipt.processor.domain.rule;

import dev.receipt.processor.domain.entity.Item;
import dev.receipt.processor.domain.rule.shared.Rule;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Objects.nonNull;

@Bean
@Named("itemsRule")
@RequiredArgsConstructor
public class ItemsRule implements Rule<List<Item>> {

    private final Rule<Item> itemRule;

    @Override
    public Long process(List<Item> items) {
        long sum = 0L;

        if (nonNull(items) && items.size() > 0) {
            var sizeMultipleTwo = items.size() / 2;
            sum += sizeMultipleTwo * 5L;

            sum += items.parallelStream()
                .map(itemRule::process)
                .reduce(0L, Long::sum);
        }

        return sum;
    }

}
