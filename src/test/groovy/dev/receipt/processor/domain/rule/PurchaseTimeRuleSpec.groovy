package dev.receipt.processor.domain.rule

import spock.lang.Specification

import java.time.LocalTime

class PurchaseTimeRuleSpec extends Specification {

    def "Calculates points if time is between 2:00pm and 4:00pm when purchaseTime: #purchaseTime == #points points" () {
        given:
        def rule = new PurchaseTimeRule()

        when:
        def result = rule.process(purchaseTime)

        then:
        result == points

        where:
        purchaseTime         || points
        null                 || 0
        LocalTime.of(8, 13)  || 0
        LocalTime.of(13, 13) || 0
        LocalTime.of(13, 1)  || 0
        LocalTime.of(20, 1)  || 0
        LocalTime.of(14, 33) || 10
    }

}