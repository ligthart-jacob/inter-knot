package com.rosea.api.mapper;

import com.rosea.api.dto.DailyTaskDto;
import com.rosea.api.dto.RegularTaskDto;
import com.rosea.api.model.DailyTask;
import com.rosea.api.model.RegularTask;
import org.mapstruct.Mapper;

@Mapper(config = GlobalConfig.class, uses = { CompletionMapper.class })
public interface DailyTaskMapper {
    DailyTask toEntity(RegularTaskDto dto);

    DailyTaskDto toDto(RegularTask entity);
}

