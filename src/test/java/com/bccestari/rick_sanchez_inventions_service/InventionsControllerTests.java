package com.bccestari.rick_sanchez_inventions_service;


import com.bccestari.rick_sanchez_inventions_service.models.Invention;
import com.bccestari.rick_sanchez_inventions_service.models.InventionDto;
import com.bccestari.rick_sanchez_inventions_service.repositories.InventionsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Import(value = TestConfig.class)

public class InventionsControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private InventionsRepository repo;

    @Test
    public void testCreateInventionSuccess() {
        InventionDto inventionDto = new InventionDto();
        inventionDto.setName("Test Invention");
        inventionDto.setCategory("Test Category");
        inventionDto.setPrice("100");
        inventionDto.setDescription("This is a valid description.");

        webTestClient.post()
                .uri("/api/inventions")
                .bodyValue(inventionDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Test Invention")
                .jsonPath("$.category").isEqualTo("Test Category")
                .jsonPath("$.price").isEqualTo(100.0)
                .jsonPath("$.description").isEqualTo("This is a valid description.");
    }

    @Test
    public void testCreateInventionFailure() {
        InventionDto inventionDto = new InventionDto();
        inventionDto.setName(""); // Invalid name
        inventionDto.setCategory(""); // Invalid category
        inventionDto.setPrice("not-a-number"); // Invalid price
        inventionDto.setDescription("Short");

        webTestClient.post()
                .uri("/api/inventions")
                .bodyValue(inventionDto)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody()
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.category").isNotEmpty()
                .jsonPath("$.price").isNotEmpty()
                .jsonPath("$.description").isNotEmpty();
    }

    @Test
    public void testGetInventionSuccess() {
        Invention invention = new Invention();
        invention.setName("Existing Invention");
        invention.setCategory("Existing Category");
        invention.setPrice(50.0);
        invention.setDescription("This is an existing invention.");
        invention.setCreatedAt(new Date());
        repo.save(invention);

        // Test fetching the saved invention
        webTestClient.get()
                .uri("/api/inventions/" + invention.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Existing Invention")
                .jsonPath("$.category").isEqualTo("Existing Category")
                .jsonPath("$.price").isEqualTo(50.0)
                .jsonPath("$.description").isEqualTo("This is an existing invention.");
    }

    @Test
    public void testGetInventionNotFound() {
        webTestClient.get()
                .uri("/api/inventions/999") // Assuming 999 is a non-existent ID
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void testUpdateInventionSuccess() {
        Invention invention = new Invention();
        invention.setName("Old Name");
        invention.setCategory("Old Category");
        invention.setPrice(20.0);
        invention.setDescription("Old description.");
        invention.setCreatedAt(new Date());
        repo.save(invention);

        InventionDto updatedInventionDto = new InventionDto();
        updatedInventionDto.setName("New Name");
        updatedInventionDto.setCategory("New Category");
        updatedInventionDto.setPrice("30");
        updatedInventionDto.setDescription("Updated description.");

        webTestClient.put()
                .uri("/api/inventions/" + invention.getId())
                .bodyValue(updatedInventionDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("New Name")
                .jsonPath("$.category").isEqualTo("New Category")
                .jsonPath("$.price").isEqualTo(30.0)
                .jsonPath("$.description").isEqualTo("Updated description.");
    }

    @Test
    public void testDeleteInventionSuccess() {
        // First, save a invention to the repository
        Invention invention = new Invention();
        invention.setName("Invention to Delete");
        invention.setCategory("Category");
        invention.setPrice(15.0);
        invention.setDescription("Description");
        invention.setCreatedAt(new Date());
        repo.save(invention);





        webTestClient.delete()
                .uri("/api/inventions/" + invention.getId())
                .exchange()
                .expectStatus().isOk();

    }
}


