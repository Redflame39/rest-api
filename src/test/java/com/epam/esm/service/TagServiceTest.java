package com.epam.esm.service;

import com.epam.esm.converter.TagToTagDtoConverter;
import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.repository.api.TagRepository;
import com.epam.esm.service.impl.TagServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TagServiceTest {

    private final TagToTagDtoConverter converter = new TagToTagDtoConverter();

    @InjectMocks
    private TagServiceImpl service;

    @Mock
    private TagRepository<Long> tagRepository;

    private MockitoSession session;

    @BeforeEach
    public void beforeMethod() {
        session = Mockito.mockitoSession()
                .initMocks(this)
                .startMocking();
    }

    @AfterEach
    public void afterMethod() {
        session.finishMocking();
    }

    @Test
    void createTest() {
        Tag tag = Tag.builder()
                .name("name")
                .build();
        TagDto tagDto = converter.convert(tag);
        when(tagRepository.create(tagDto))
                .thenReturn(100L);
        when(tagRepository.findById(100L))
                .thenReturn(Optional.of(tag));
        TagDto expected = tagDto;
        TagDto actual = service.create(tagDto);
        assertEquals(expected, actual);
    }

    @Test
    void findAllTest() {
        Tag tagName = Tag.builder()
                .name("name")
                .build();
        Tag tag = Tag.builder()
                .name("tag")
                .build();
        Tag tagQwe = Tag.builder()
                .name("qwe")
                .build();
        List<Tag> tags = new ArrayList<>();
        Collections.addAll(tags, tag, tagName, tagQwe);
        when(tagRepository.findAll())
                .thenReturn(tags);
        List<TagDto> expected = tags.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        List<TagDto> actual = service.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findByCertificateIdTest() {
        Tag tag1 = Tag.builder()
                .name("name")
                .build();

        Tag tag2 = Tag.builder()
                .name("Tag")
                .build();

        List<Tag> tags = new ArrayList<>();
        Collections.addAll(tags, tag1, tag2);
        when(tagRepository.findByCertificateId(100L))
                .thenReturn(tags);
        List<TagDto> expected = tags.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        List<TagDto> actual = service.findByCertificateId(100L);
        assertEquals(expected, actual);
    }

    @Test
    void findByIdTest() {
        Tag tag = Tag.builder()
                .id(100L)
                .name("name")
                .build();
        when(tagRepository.findById(100L))
                .thenReturn(Optional.of(tag));
        TagDto expected = converter.convert(tag);
        TagDto actual = service.findById(100L);
        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        when(tagRepository.delete(100L))
                .thenReturn(true);
        Tag tag = Tag.builder()
                .name("name")
                .build();
        when(tagRepository.findById(100L))
                .thenReturn(Optional.of(tag));
        TagDto expected = converter.convert(tag);
        TagDto actual = service.delete(100L);
        assertEquals(expected, actual);
    }
}