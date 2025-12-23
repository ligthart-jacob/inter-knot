package com.rosea.api.mapper;

import com.rosea.api.dto.DailyTaskDto;
import com.rosea.api.dto.RegularTaskDto;
import com.rosea.api.dto.TaskDto;
import com.rosea.api.model.Completion;
import com.rosea.api.model.DailyTask;
import com.rosea.api.model.RegularTask;
import com.rosea.api.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-23T02:11:34+0100",
    comments = "version: 1.6.0, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Autowired
    private RegularTaskMapper regularTaskMapper;

    @Override
    public Task toEntity(TaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        if (dto instanceof RegularTaskDto) {
            return regularTaskMapper.toEntity( (RegularTaskDto) dto );
        }
        else if (dto instanceof DailyTaskDto) {
            return dailyTaskDtoToDailyTask( (DailyTaskDto) dto );
        }
        else {
            throw new IllegalArgumentException("Not all subclasses are supported for this mapping. Missing for " + dto.getClass());
        }
    }

    @Override
    public TaskDto toDto(Task entity) {
        if ( entity == null ) {
            return null;
        }

        if (entity instanceof RegularTask) {
            return regularTaskMapper.toDto( (RegularTask) entity );
        }
        else if (entity instanceof DailyTask) {
            return dailyTaskToDailyTaskDto( (DailyTask) entity );
        }
        else {
            TaskDto taskDto = new TaskDto();

            taskDto.setId( (int) entity.getId() );
            taskDto.setName( entity.getName() );
            taskDto.setChildren( taskListToTaskDtoList( entity.getChildren() ) );

            return taskDto;
        }
    }

    protected List<Task> taskDtoListToTaskList(List<TaskDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Task> list1 = new ArrayList<Task>( list.size() );
        for ( TaskDto taskDto : list ) {
            list1.add( toEntity( taskDto ) );
        }

        return list1;
    }

    protected DailyTask dailyTaskDtoToDailyTask(DailyTaskDto dailyTaskDto) {
        if ( dailyTaskDto == null ) {
            return null;
        }

        DailyTask dailyTask = new DailyTask();

        dailyTask.setId( dailyTaskDto.getId() );
        dailyTask.setName( dailyTaskDto.getName() );
        dailyTask.setChildren( taskDtoListToTaskList( dailyTaskDto.getChildren() ) );
        List<Completion> list1 = dailyTaskDto.getCompletions();
        if ( list1 != null ) {
            dailyTask.setCompletions( new ArrayList<Completion>( list1 ) );
        }

        setParentRecursively( dailyTask );

        return dailyTask;
    }

    protected List<TaskDto> taskListToTaskDtoList(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDto> list1 = new ArrayList<TaskDto>( list.size() );
        for ( Task task : list ) {
            list1.add( toDto( task ) );
        }

        return list1;
    }

    protected DailyTaskDto dailyTaskToDailyTaskDto(DailyTask dailyTask) {
        if ( dailyTask == null ) {
            return null;
        }

        DailyTaskDto dailyTaskDto = new DailyTaskDto();

        dailyTaskDto.setId( (int) dailyTask.getId() );
        dailyTaskDto.setName( dailyTask.getName() );
        dailyTaskDto.setChildren( taskListToTaskDtoList( dailyTask.getChildren() ) );
        List<Completion> list1 = dailyTask.getCompletions();
        if ( list1 != null ) {
            dailyTaskDto.setCompletions( new ArrayList<Completion>( list1 ) );
        }

        return dailyTaskDto;
    }
}
