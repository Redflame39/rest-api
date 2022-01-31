package com.epam.esm.repository;

import com.epam.esm.configuration.DBTestConfig;
import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.repository.api.TagRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DBTestConfig.class})
@Transactional
class TagRepositoryTest {

    private final TagRepository<Long> repository;

    @Autowired
    public TagRepositoryTest(TagRepository<Long> repository) {
        this.repository = repository;
    }

    @Test
    void findAllTest() {
        int expected = 4;
        int actual = repository.findAll().size();
        assertEquals(expected, actual);
    }

    @Test
    void findByIdTest() {
        Long id = 1L;
        Optional<Tag> tag = repository.findById(id);
        Tag item = tag.get();
        Long expected = 1L;
        Long actual = item.getId();
        assertEquals(expected, actual);
    }

    @Test
    void createTest() {
        TagDto tag = TagDto.builder()
                .name("Name")
                .build();

        Long expected = 5L;
        Long actual = repository.create(tag);

        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        Long id = 1L;
        boolean deleted = repository.delete(id);
        assertTrue(deleted);
    }

    @Test
    void findByNameTest() {
        String name = "Cars";
        Optional<Tag> tag = repository.findByName(name);
        Tag item = tag.get();
        String expected = name;
        String actual = item.getName();
        assertEquals(expected, actual);
    }

    @Test
    void findByCertificateIdTest() {
        Long id = 1L;
        Optional<Tag> tag = repository.findById(id);
        Tag item = tag.get();
        Long expected = id;
        Long actual = item.getId();
        assertEquals(expected, actual);
    }

}