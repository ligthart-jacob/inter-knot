package com.rosea.api.mapper;

import com.rosea.api.dto.DailyTaskDto;
import com.rosea.api.model.DailyTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GlobalConfig.class, uses = { TaskMapper.class, CompletionMapper.class })
public interface DailyTaskMapper {
    @Mapping(target = "children", qualifiedByName = "mapChildren")
    DailyTask toEntity(DailyTaskDto dto);

    @Mapping(target = "children", qualifiedByName = "mapChildrenDto")
    DailyTaskDto toDto(DailyTask entity);
}

