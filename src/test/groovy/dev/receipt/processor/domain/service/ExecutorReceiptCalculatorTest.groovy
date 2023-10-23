package dev.receipt.processor.domain.service

import dev.receipt.processor.domain.entity.Item
import dev.receipt.processor.domain.entity.Receipt
import dev.receipt.processor.domain.rule.ItemRule
import dev.receipt.processor.domain.rule.ItemsRule
import dev.receipt.processor.domain.rule.PurchaseDateRule
import dev.receipt.processor.domain.rule.PurchaseTimeRule
import dev.receipt.processor.domain.rule.RetailerRule
import dev.receipt.processor.domain.rule.TotalRule
import dev.receipt.processor.domain.service.shared.Calculator
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalTime

class ExecutorReceiptCalculatorTest extends Specification {

    Calculator<Receipt> calculator

    def setup() {
        calculator = new ExecutorReceiptCalculator(
            new RetailerRule(),
            new PurchaseDateRule(),
            new PurchaseTimeRule(),
            new TotalRule(),
            new ItemsRule(
                new ItemRule()
            )
        )
    }
    def "Executors Receipt sum"() {
        given:
        def receipt = new Receipt(
            id: UUID.randomUUID(),
            retailer: 'Corner Market',
            purchaseDate: LocalDate.of(2022, 1, 1),
            purchaseTime: LocalTime.of(14, 33),
            total: 9.00,
            items: [
                new Item('Gatorade', 4.87),
                new Item('Gatorade', 2.25),
                new Item('Gatorade', 10.25),
                new Item('Gatorade', 2.25),
            ]
        )

        when:
        def sum = calculator.sum(receipt)

        then:
        sum == 113
    }
}
