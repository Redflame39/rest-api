package com.epam.esm.repository;

import com.epam.esm.configuration.DBTestConfig;
import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.dto.UpdatingCertificateDto;
import com.epam.esm.model.entity.Certificate;
import com.epam.esm.model.entity.OrderType;
import com.epam.esm.model.entity.SortType;
import com.epam.esm.repository.api.CertificateRepository;
import com.epam.esm.repository.specification.SpecificationCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DBTestConfig.class})
@Transactional
class CertificateRepositoryTest {

    private final CertificateRepository<Long> repository;

    @Autowired
    public CertificateRepositoryTest(CertificateRepository<Long> repository) {
        this.repository = repository;
    }

    @Test
    void findByIdExistingIdNotEmptyResultTest() {
        Long id = 1L;
        Optional<Certificate> certificate = repository.findById(id);
        boolean isPresent = certificate.isPresent();
        assertTrue(isPresent);
    }

    @Test
    void findByIdExistingIdCorrectObjectTest() {
        Long id = 1L;
        Optional<Certificate> certificate = repository.findById(id);
        Certificate item = certificate.get();
        Long expected = id;
        Long actual = item.getId();
        assertEquals(expected, actual);
    }

    @Test
    void createTest() {
        UpdatingCertificateDto dto = new UpdatingCertificateDto();
        dto.setName("qwe");
        dto.setDescription("desc");
        dto.setDuration(456);
        dto.setPrice(3456.0);
        List<TagDto> tags = new ArrayList<>();
        tags.add(TagDto.builder()
                .name("Tag")
                .build());
        dto.setTags(tags);
        Long id = repository.create(dto);
        assertTrue(id > 0);
    }

    @Test
    void updateReturnsTrueTest() {
        Long updateId = 1L;
        String newName = "Name";
        UpdatingCertificateDto dto = new UpdatingCertificateDto();
        dto.setName(newName);
        boolean updated = repository.update(updateId, dto);
        assertTrue(updated);
    }

    @Test
    void updateChangesNameTest() {
        Long updateId = 1L;
        String newName = "Name";
        UpdatingCertificateDto dto = new UpdatingCertificateDto();
        dto.setName(newName);
        Optional<Certificate> oldCertificate = repository.findById(updateId);
        String oldName = oldCertificate.get().getName();
        repository.update(updateId, dto);
        Optional<Certificate> certificateAfterUpdating = repository.findById(updateId);
        String nameAfterUpdating = certificateAfterUpdating.get().getName();
        assertNotEquals(oldName, nameAfterUpdating);
    }

    @Test
    void updateCorrectRenamingTest() {
        Long updateId = 1L;
        String newName = "Name";
        UpdatingCertificateDto dto = new UpdatingCertificateDto();
        dto.setName(newName);
        repository.update(updateId, dto);
        Optional<Certificate> certificateAfterUpdating = repository.findById(updateId);
        String nameAfterUpdating = certificateAfterUpdating.get().getName();
        assertEquals(newName, nameAfterUpdating);
    }

    @Test
    void deleteTest() {
        Long deleteId = 1L;
        boolean deleted = repository.delete(deleteId);
        assertTrue(deleted);
    }

    @Test
    void findBySpecificationCorrectObjectsCountTest() {
        SpecificationCreator specificationCreator = new SpecificationCreator();
        Specification specification = specificationCreator.createSpecification("certificate",
                null, null, SortType.NONE, OrderType.ASC);

        List<Certificate> certificates = repository.findBySpecification(specification);
        int expected = 2;
        int actual = certificates.size();
        assertEquals(expected, actual);
    }
}