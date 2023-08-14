package dev.receipt.processor.domain.rule.shared;

public interface Rule<T> {

    Long process(T t);

}
