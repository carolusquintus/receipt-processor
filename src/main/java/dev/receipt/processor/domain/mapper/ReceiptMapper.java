package dev.receipt.processor.domain.mapper;

import dev.receipt.processor.domain.dto.ReceiptDto;
import dev.receipt.processor.domain.entity.Receipt;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.JAKARTA;

@Mapper(componentModel = JAKARTA)
public interface ReceiptMapper {

    Receipt toEntity(ReceiptDto receiptDto);

}
