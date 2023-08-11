package dev.receipt.processor.application.port.output;

public interface EntityRepository<K, T> {

    T save(T type);

    T fetchById(K key);

}
