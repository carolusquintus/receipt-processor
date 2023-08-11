package dev.receipt.processor.application.usecase;

import dev.receipt.processor.domain.entity.Points;
import dev.receipt.processor.domain.entity.Receipt;
import dev.receipt.processor.domain.entity.ReceiptId;

public interface ReceiptUseCase {

    ReceiptId addReceipt(Receipt receipt);

    Points calculatePoints(ReceiptId id);

}
