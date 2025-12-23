package com.rosea.api.mapper;

import com.rosea.api.dto.RegularTaskDto;
import com.rosea.api.model.RegularTask;
import org.mapstruct.Mapper;

@Mapper(config = GlobalConfig.class)
public interface RegularTaskMapper {
    RegularTask toEntity(RegularTaskDto dto);

    RegularTaskDto toDto(RegularTask entity);
}
