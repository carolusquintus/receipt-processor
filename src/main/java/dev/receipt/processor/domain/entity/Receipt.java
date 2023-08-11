package dev.receipt.processor.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record Receipt(
    String retailer,
    LocalDate purchaseDate,
    LocalTime purchaseTime,
    BigDecimal total,
    List<Item> items
) {
}
