package com.rosea.api.mapper;

import com.rosea.api.dto.DailyTaskDto;
import com.rosea.api.dto.RegularTaskDto;
import com.rosea.api.dto.TaskDto;
import com.rosea.api.model.DailyTask;
import com.rosea.api.model.RegularTask;
import com.rosea.api.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-21T15:10:07+0100",
    comments = "version: 1.6.0, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class DailyTaskMapperImpl implements DailyTaskMapper {

    @Override
    public DailyTask toEntity(RegularTaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        DailyTask dailyTask = new DailyTask();

        dailyTask.setName( dto.getName() );
        dailyTask.setChildren( taskDtoListToTaskList( dto.getChildren() ) );

        return dailyTask;
    }

    @Override
    public DailyTaskDto toDto(RegularTask entity) {
        if ( entity == null ) {
            return null;
        }

        DailyTaskDto dailyTaskDto = new DailyTaskDto();

        dailyTaskDto.setName( entity.getName() );
        dailyTaskDto.setChildren( taskListToTaskDtoList( entity.getChildren() ) );

        return dailyTaskDto;
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
