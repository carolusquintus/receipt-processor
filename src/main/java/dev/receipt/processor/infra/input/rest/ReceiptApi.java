package dev.receipt.processor.infra.input.rest;

import dev.receipt.processor.domain.entity.Points;
import dev.receipt.processor.domain.entity.Receipt;
import dev.receipt.processor.domain.entity.ReceiptId;
import io.micronaut.http.annotation.*;

import java.util.UUID;

@Controller("/receipts")
public class ReceiptApi {

    @Post("/process")
    public ReceiptId postReceiptProcess(@Body Receipt receipt) {
        return new ReceiptId(UUID.randomUUID());
    }

    @Get("/{id}/points")
    public Points getReceiptPoints(@PathVariable UUID id) {
        return new Points(54L);
    }

}
