package dev.receipt.processor.infra.output.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.receipt.processor.application.port.output.EntityRepository;
import dev.receipt.processor.domain.entity.Receipt;
import io.micronaut.context.annotation.Bean;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Bean
@RequiredArgsConstructor
public class ReceiptRedisRepository implements EntityRepository<UUID, Receipt> {

    private final ObjectMapper mapper;
    @Override
    public Receipt save(Receipt receipt) {
        String receiptJson = null;
        try {
            receiptJson = mapper.writeValueAsString(receipt);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Receipt fetchById(UUID key) {
        return null;
    }

}
