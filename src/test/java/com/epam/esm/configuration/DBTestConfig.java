package com.epam.esm.configuration;

import com.epam.esm.repository.api.CertificateRepository;
import com.epam.esm.repository.api.CertificateTagRepository;
import com.epam.esm.repository.api.TagRepository;
import com.epam.esm.repository.impl.CertificateRepositoryImpl;
import com.epam.esm.repository.impl.CertificateTagRepositoryImpl;
import com.epam.esm.repository.impl.TagRepositoryImpl;
import com.epam.esm.service.api.TagService;
import com.epam.esm.service.impl.TagServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DBTestConfig {

    private static final String SCRIPT_ENCODING = "UTF-8";

    @Bean
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding(SCRIPT_ENCODING)
                .addScript("db/schema.sql")
                .addScript("db/values.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(h2DataSource());
    }

    @Bean
    public CertificateRepository<Long> certificateRepository(ApplicationContext applicationContext) {
        return new CertificateRepositoryImpl(jdbcTemplate(), applicationContext);
    }

    @Bean
    public TagRepository<Long> tagRepository(ApplicationContext applicationContext) {
        return new TagRepositoryImpl(jdbcTemplate(), applicationContext);
    }

    @Bean
    public CertificateTagRepository<Long> certificateTagRepository() {
        return new CertificateTagRepositoryImpl(jdbcTemplate());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(h2DataSource());
        return dataSourceTransactionManager;
    }

}
