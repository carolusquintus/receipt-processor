package dev.receipt.processor.application.usecase;

import dev.receipt.processor.domain.dto.ReceiptDto;
import dev.receipt.processor.domain.entity.Points;
import dev.receipt.processor.domain.entity.ReceiptId;

public interface ReceiptUseCase {

    ReceiptId addReceipt(ReceiptDto receiptDto);

    Points calculatePoints(ReceiptId id);

}
