package dev.receipt.processor.domain.service;

import dev.receipt.processor.domain.entity.Item;
import dev.receipt.processor.domain.entity.Receipt;
import dev.receipt.processor.domain.rule.shared.Rule;
import dev.receipt.processor.domain.service.shared.Calculator;
import io.micronaut.context.annotation.Bean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

@Bean
@Slf4j
@RequiredArgsConstructor
public class ParallelReceiptCalculator implements Calculator<Receipt> {

    private final Rule<String> retailerRule;
    private final Rule<LocalDate> purchaseDateRule;
    private final Rule<LocalTime> purchaseTimeRule;
    private final Rule<BigDecimal> totalRule;
    private final Rule<List<Item>> itemsRule;

    @Override
    public Long sum(Receipt receipt) {
        return Stream.<Callable<Long>>of(
            () -> retailerRule.process(receipt.getRetailer()),
            () -> purchaseDateRule.process(receipt.getPurchaseDate()),
            () -> purchaseTimeRule.process(receipt.getPurchaseTime()),
            () -> totalRule.process(receipt.getTotal()),
            () -> itemsRule.process(receipt.getItems())
            )
            .parallel()
            .map(this::processedRule)
            .reduce(0L, Long::sum);
    }

    private Long processedRule(Callable<Long> rule) {
        try {
            return rule.call();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0L;
        }
    }
}
