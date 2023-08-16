package dev.receipt.processor.domain.rule

import spock.lang.Specification

import java.time.LocalDate

class PurchaseDateRuleSpec extends Specification {

     def "Calculates points if day of month is odd when purchaseDate: #purchaseDate == #points points" () {
        given:
        def rule = new PurchaseDateRule()

        when:
        def result = rule.process(purchaseDate)

        then:
        result == points

        where:
        purchaseDate              || points
        null                      || 0
        LocalDate.of(2022, 1, 1)  || 6
        LocalDate.of(2022, 1, 2)  || 0
        LocalDate.of(2022, 3, 20) || 0
    }

}