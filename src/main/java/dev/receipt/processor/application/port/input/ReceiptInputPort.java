package dev.receipt.processor.application.port.input;

import dev.receipt.processor.application.port.output.EntityRepository;
import dev.receipt.processor.application.usecase.ReceiptUseCase;
import dev.receipt.processor.domain.dto.ReceiptDto;
import dev.receipt.processor.domain.entity.Points;
import dev.receipt.processor.domain.entity.Receipt;
import dev.receipt.processor.domain.entity.ReceiptId;
import dev.receipt.processor.domain.mapper.ReceiptMapper;
import io.micronaut.context.annotation.Bean;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Bean
@RequiredArgsConstructor
public class ReceiptInputPort implements ReceiptUseCase {

    private final ReceiptMapper mapper;
    private final EntityRepository<UUID, Receipt> repository;

    @Override
    public ReceiptId addReceipt(ReceiptDto receiptDto) {
        final var id = UUID.randomUUID();

        var receipt = mapper.toEntity(receiptDto);
        receipt.setId(id);

        repository.save(receipt);

        return new ReceiptId(id);
    }

    @Override
    public Points calculatePoints(ReceiptId id) {
        return new Points(82L);
    }

}
