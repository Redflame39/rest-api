package com.epam.esm.repository;

import com.epam.esm.configuration.DBTestConfig;
import com.epam.esm.model.dto.TagDto;
import com.epam.esm.repository.api.CertificateTagRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DBTestConfig.class})
@Transactional
class CertificateTagRepositoryTest {

    private final CertificateTagRepository<Long> repository;

    @Autowired
    public CertificateTagRepositoryTest(CertificateTagRepository<Long> repository) {
        this.repository = repository;
    }

    @Test
    void addTagsTest() {
        Long certificateId = 1L;
        List<TagDto> tags = new ArrayList<>();
        TagDto tag1 = TagDto.builder()
                .id(1L)
                .build();

        TagDto tag2 = TagDto.builder()
                .id(2L)
                .build();

        Collections.addAll(tags, tag1, tag2);

        boolean added = repository.addTags(certificateId, tags);
        assertTrue(added);
    }

    @Test
    void clearTagsTest() {
        Long certificateId = 1L;
        boolean added = repository.clearTags(certificateId);
        assertTrue(added);
    }

}