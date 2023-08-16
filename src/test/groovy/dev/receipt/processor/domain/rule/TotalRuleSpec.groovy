package dev.receipt.processor.domain.rule

import spock.lang.Specification

class TotalRuleSpec extends Specification {

    def "Calculates points if total is round dollar without cents or multiple of 0.25 when total: #total == #points points" () {
        given:
        def rule = new TotalRule()

        when:
        def result = rule.process(total)

        then:
        result == points

        where:
        total                   || points
        null                    || 0
        new BigDecimal("35.35") || 0
        new BigDecimal("2.65")  || 0
        new BigDecimal("1.25")  || 25
        new BigDecimal("9.00")  || 75
    }

}