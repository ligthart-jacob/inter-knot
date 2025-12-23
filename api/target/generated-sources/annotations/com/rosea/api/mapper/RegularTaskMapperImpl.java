package com.rosea.api.mapper;

import com.rosea.api.dto.RegularTaskDto;
import com.rosea.api.dto.TaskDto;
import com.rosea.api.model.RegularTask;
import com.rosea.api.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-21T15:13:48+0100",
    comments = "version: 1.6.0, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class RegularTaskMapperImpl implements RegularTaskMapper {

    @Override
    public RegularTask toEntity(RegularTaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        RegularTask regularTask = new RegularTask();

        regularTask.setName( dto.getName() );
        regularTask.setChildren( taskDtoListToTaskList( dto.getChildren() ) );
        regularTask.setCompleted( dto.isCompleted() );
        regularTask.setDate( dto.getDate() );

        return regularTask;
    }

    @Override
    public RegularTaskDto toDto(RegularTask entity) {
        if ( entity == null ) {
            return null;
        }

        RegularTaskDto regularTaskDto = new RegularTaskDto();

        regularTaskDto.setName( entity.getName() );
        regularTaskDto.setChildren( taskListToTaskDtoList( entity.getChildren() ) );
        regularTaskDto.setCompleted( entity.isCompleted() );
        regularTaskDto.setDate( entity.getDate() );

        return regularTaskDto;
    }

    protected Task taskDtoToTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setName( taskDto.getName() );
        task.setChildren( taskDtoListToTaskList( taskDto.getChildren() ) );

        return task;
    }

    protected List<Task> taskDtoListToTaskList(List<TaskDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Task> list1 = new ArrayList<Task>( list.size() );
        for ( TaskDto taskDto : list ) {
            list1.add( taskDtoToTask( taskDto ) );
        }

        return list1;
    }

    protected TaskDto taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setName( task.getName() );
        taskDto.setChildren( taskListToTaskDtoList( task.getChildren() ) );

        return taskDto;
    }

    protected List<TaskDto> taskListToTaskDtoList(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDto> list1 = new ArrayList<TaskDto>( list.size() );
        for ( Task task : list ) {
            list1.add( taskToTaskDto( task ) );
        }

        return list1;
    }
}
