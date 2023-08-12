package dev.receipt.processor.domain.dto;

import dev.receipt.processor.domain.entity.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record ReceiptDto(
    String retailer,
    LocalDate purchaseDate,
    LocalTime purchaseTime,
    BigDecimal total,
    List<Item>items
) {}
