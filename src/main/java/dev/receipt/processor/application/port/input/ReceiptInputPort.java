package dev.receipt.processor.application.port.input;

import dev.receipt.processor.application.usecase.ReceiptUseCase;
import dev.receipt.processor.domain.entity.Points;
import dev.receipt.processor.domain.entity.Receipt;
import dev.receipt.processor.domain.entity.ReceiptId;
import io.micronaut.context.annotation.Bean;

import java.util.UUID;

@Bean
public class ReceiptInputPort implements ReceiptUseCase {

    @Override
    public ReceiptId addReceipt(Receipt receipt) {
        return new ReceiptId(UUID.randomUUID());
    }

    @Override
    public Points calculatePoints(ReceiptId id) {
        return new Points(82L);
    }

}
