package com.rosea.api.mapper;

import com.rosea.api.dto.CompletionDto;
import com.rosea.api.model.Completion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-23T02:51:39+0100",
    comments = "version: 1.6.0, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class CompletionMapperImpl implements CompletionMapper {

    @Override
    public Completion toEntity(CompletionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Completion completion = new Completion();

        completion.setDate( dto.getDate() );
        completion.setCompleted( dto.isCompleted() );

        return completion;
    }

    @Override
    public CompletionDto toDto(Completion entity) {
        if ( entity == null ) {
            return null;
        }

        CompletionDto completionDto = new CompletionDto();

        completionDto.setDate( entity.getDate() );
        completionDto.setCompleted( entity.isCompleted() );

        return completionDto;
    }
}
