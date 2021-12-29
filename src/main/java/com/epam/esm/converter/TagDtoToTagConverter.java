package com.epam.esm.converter;

import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.entity.Tag;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TagDtoToTagConverter implements Converter<TagDto, Tag> {

    @Override
    public Tag convert(TagDto source) {
        return Tag.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

}
