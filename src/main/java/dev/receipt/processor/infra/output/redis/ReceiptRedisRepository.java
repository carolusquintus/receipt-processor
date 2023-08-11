package dev.receipt.processor.infra.output.redis;

import dev.receipt.processor.application.port.output.EntityRepository;
import dev.receipt.processor.domain.entity.Receipt;
import io.micronaut.context.annotation.Bean;

import java.util.UUID;

@Bean
public class ReceiptRedisRepository implements EntityRepository<UUID, Receipt> {

    @Override
    public Receipt save(Receipt type) {
        return null;
    }

    @Override
    public Receipt fetchById(UUID key) {
        return null;
    }

}
