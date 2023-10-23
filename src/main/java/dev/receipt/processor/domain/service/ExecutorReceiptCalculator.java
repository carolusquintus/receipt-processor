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
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Bean
@Slf4j
@RequiredArgsConstructor
public class ExecutorReceiptCalculator implements Calculator<Receipt> {

    private final Rule<String> retailerRule;
    private final Rule<LocalDate> purchaseDateRule;
    private final Rule<LocalTime> purchaseTimeRule;
    private final Rule<BigDecimal> totalRule;
    private final Rule<List<Item>> itemsRule;

    @Override
    public Long sum(Receipt receipt) {
        var finalResult = 0L;

        var callables = List.<Callable<Long>>of(
            () -> retailerRule.process(receipt.getRetailer()),
            () -> purchaseDateRule.process(receipt.getPurchaseDate()),
            () -> purchaseTimeRule.process(receipt.getPurchaseTime()),
            () -> totalRule.process(receipt.getTotal()),
            () -> itemsRule.process(receipt.getItems())
        );

        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            finalResult = executor.invokeAll(callables).stream()
                .map(this::processedRule)
                .reduce(0L, Long::sum);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        } finally {
            executor.shutdownNow();
        }

        return finalResult;
    }

    private Long processedRule(Future<Long> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage(), e);
            return 0L;
        }
    }

}
