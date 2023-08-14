package dev.receipt.processor.infra.output.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.receipt.processor.application.port.output.EntityRepository;
import dev.receipt.processor.domain.entity.Receipt;
import io.lettuce.core.api.StatefulRedisConnection;
import io.micronaut.context.annotation.Bean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Bean
@Slf4j
@RequiredArgsConstructor
public class ReceiptRedisRepository implements EntityRepository<UUID, Receipt> {

    private final ObjectMapper mapper;
    private final StatefulRedisConnection<String, String> connection;

    @Override
    public Receipt save(Receipt receipt) {
        String receiptJson = null;

        try {
            receiptJson = mapper.writeValueAsString(receipt);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }

        var commands = connection.sync();
        commands.set(receipt.getId().toString(), receiptJson);

        return receipt;
    }

    @Override
    public Receipt fetchById(UUID id) {
        Receipt receipt = null;

        var commands = connection.sync();
        var receiptJson = commands.get(id.toString());

        try {
            receipt = mapper.readValue(receiptJson, Receipt.class);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }

        log.debug("Receipt: {}", receipt);

        return receipt;
    }

}
