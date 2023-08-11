package dev.receipt.processor.infra.input.rest;

import dev.receipt.processor.application.usecase.ReceiptUseCase;
import dev.receipt.processor.domain.entity.Points;
import dev.receipt.processor.domain.entity.Receipt;
import dev.receipt.processor.domain.entity.ReceiptId;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Controller("/receipts")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptUseCase useCase;

    @Post("/process")
    public ReceiptId postReceiptProcess(@Body Receipt receipt) {
        return useCase.addReceipt(receipt);
    }

    @Get("/{id}/points")
    public Points getReceiptPoints(@PathVariable UUID id) {
        return useCase.calculatePoints(new ReceiptId(id));
    }

}
