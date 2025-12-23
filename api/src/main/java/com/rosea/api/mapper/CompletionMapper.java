package com.rosea.api.mapper;

import com.rosea.api.dto.CompletionDto;
import com.rosea.api.model.Completion;
import org.mapstruct.Mapper;

@Mapper(config = GlobalConfig.class)
public interface CompletionMapper {
    Completion toEntity(CompletionDto dto);
    CompletionDto toDto(Completion entity);
}
