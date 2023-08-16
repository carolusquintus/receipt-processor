package dev.receipt.processor.domain.rule

import spock.lang.Specification

class RetailerRuleSpec extends Specification {

    def "Calculates points when retailer: #retailer == #points points" () {
        given:
        def rule = new RetailerRule()

        when:
        def result = rule.process(retailer)

        then:
        result == points

        where:
        retailer            || points
        null                || 0
        ''                  || 0
        ' '                 || 0
        'Target'            || 6
        'M&M Corner Market' || 14

    }

}