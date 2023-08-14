package dev.receipt.processor.domain.service;

import dev.receipt.processor.domain.entity.Item;
import dev.receipt.processor.domain.entity.Receipt;
import dev.receipt.processor.domain.rule.shared.Rule;
import dev.receipt.processor.domain.service.shared.Calculator;
import io.micronaut.context.annotation.Bean;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Bean
@RequiredArgsConstructor
public class ReceiptCalculator implements Calculator<Receipt> {

    private final Rule<String> retailerRule;
    private final Rule<LocalDate> purchaseDateRule;
    private final Rule<LocalTime> purchaseTimeRule;
    private final Rule<BigDecimal> totalRule;
    private final Rule<List<Item>> itemsRule;

    @Override
    public Long sum(Receipt receipt) {
        return
            retailerRule.process(receipt.getRetailer()) +
            purchaseDateRule.process(receipt.getPurchaseDate()) +
            purchaseTimeRule.process(receipt.getPurchaseTime()) +
            totalRule.process(receipt.getTotal()) +
            itemsRule.process(receipt.getItems());
    }

}
