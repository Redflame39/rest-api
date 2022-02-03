package com.epam.esm.service;

import com.epam.esm.converter.CertificateToCertificateDtoConverter;
import com.epam.esm.model.dto.CertificateDto;
import com.epam.esm.model.dto.CreatingCertificateDto;
import com.epam.esm.model.dto.UpdatingCertificateDto;
import com.epam.esm.model.entity.Certificate;
import com.epam.esm.repository.api.CertificateRepository;
import com.epam.esm.repository.api.CertificateTagRepository;
import com.epam.esm.repository.api.TagRepository;
import com.epam.esm.service.impl.CertificateServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CertificateServiceTest {

    private final CertificateToCertificateDtoConverter converter = new CertificateToCertificateDtoConverter();

    @InjectMocks
    private CertificateServiceImpl service;

    @Mock
    private CertificateRepository<Long> certificateRepository;

    @Mock
    private TagRepository<Long> tagRepository;

    @Mock
    private CertificateTagRepository<Long> certificateTagRepository;

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
        CreatingCertificateDto createData = new CreatingCertificateDto();
        createData.setName("name");
        createData.setDescription("qwe");
        createData.setPrice(2345.0);
        createData.setDuration(234);
        when(certificateRepository.create(createData))
                .thenReturn(100L);
        Timestamp tempDate = Timestamp.valueOf(LocalDateTime.now());
        Certificate certificate = Certificate.builder()
                .id(100L)
                .name("name")
                .description("qwe")
                .price(2345.0)
                .duration(234)
                .createDate(tempDate)
                .lastUpdateDate(tempDate)
                .build();
        when(certificateRepository.findById(100L))
                .thenReturn(Optional.of(certificate));
        CertificateDto expected = converter.convert(certificate);
        expected.setCreateDate(null);
        expected.setLastUpdateDate(null);
        CertificateDto actual = service.create(createData);
        actual.setCreateDate(null);
        actual.setLastUpdateDate(null);
        assertEquals(expected, actual);
    }

    @Test
    void createThrowsWhenNoRequiredFieldsPassedTest() {
        CreatingCertificateDto createData = new CreatingCertificateDto();
        createData.setDescription("qwe");
        createData.setPrice(2345.0);
        createData.setDuration(234);
        when(certificateRepository.create(createData))
                .thenThrow(DataIntegrityViolationException.class);
        assertThrows(DataIntegrityViolationException.class, () -> service.create(createData));
    }

    @Test
    void findAll() {
        Timestamp tempDate = Timestamp.valueOf(LocalDateTime.now());
        Certificate certificateName = Certificate.builder()
                .id(100L)
                .name("name")
                .description("qwe")
                .price(2345.0)
                .duration(234)
                .createDate(tempDate)
                .lastUpdateDate(tempDate)
                .build();
        Certificate certificateCert = Certificate.builder()
                .id(101L)
                .name("Cert")
                .description("qwe")
                .price(2345.0)
                .duration(234)
                .createDate(tempDate)
                .lastUpdateDate(tempDate)
                .build();
        Certificate certificateAnother = Certificate.builder()
                .id(102L)
                .name("Another")
                .description("qwe")
                .price(2345.0)
                .duration(234)
                .createDate(tempDate)
                .lastUpdateDate(tempDate)
                .build();
        List<Certificate> certificateDtoList = new ArrayList<>();
        Collections.addAll(certificateDtoList, certificateName, certificateCert, certificateAnother);
        when(certificateRepository.findBySpecification(Mockito.any()))
                .thenReturn(certificateDtoList);
        List<CertificateDto> expected = certificateDtoList.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
        List<CertificateDto> actual = service.findAll(null, null, null, null, null);
        assertEquals(actual, expected);
    }

    @Test
    void findByIdTest() {
        Timestamp tempDate = Timestamp.valueOf(LocalDateTime.now());
        Certificate certificate = Certificate.builder()
                .id(100L)
                .name("name")
                .description("qwe")
                .price(2345.0)
                .duration(234)
                .createDate(tempDate)
                .lastUpdateDate(tempDate)
                .build();
        when(certificateRepository.findById(100L))
                .thenReturn(Optional.of(certificate));
        CertificateDto expected= converter.convert(certificate);
        CertificateDto actual = service.findById(100L);
        assertEquals(expected, actual);
    }

    @Test
    void updateTest() {
        UpdatingCertificateDto dto = new UpdatingCertificateDto();
        dto.setName("abc");
        when(certificateRepository.update(100L, dto))
                .thenReturn(true);
        Timestamp tempDate = Timestamp.valueOf(LocalDateTime.now());
        Certificate certificate = Certificate.builder()
                .id(100L)
                .name("abc")
                .description("abc")
                .duration(100)
                .price(15d)
                .createDate(tempDate)
                .lastUpdateDate(tempDate)
                .build();
        when(certificateRepository.findById(100L))
                .thenReturn(Optional.of(certificate));
        CertificateDto expected = converter.convert(certificate);
        CertificateDto actual = service.update(100L, dto);
        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        when(certificateRepository.delete(100L))
                .thenReturn(true);
        Timestamp tempDate = Timestamp.valueOf(LocalDateTime.now());
        Certificate deleted = Certificate.builder()
                .id(100L)
                .name("qwe")
                .description("abc")
                .duration(100)
                .price(15d)
                .createDate(tempDate)
                .lastUpdateDate(tempDate)
                .build();
        when(certificateRepository.findById(100L))
                .thenReturn(Optional.of(deleted));
        CertificateDto expected = converter.convert(deleted);
        CertificateDto actual = service.delete(100L);
        assertEquals(expected, actual);
    }
}