package com.bccestari.rick_sanchez_inventions_service.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class InventionDto {
    @NotEmpty (message = "The name is required.")
    private String name;

    @NotEmpty (message = "The category is required.")
    private String category;


    @Min(0)
    private String price;

    @NotEmpty (message = "The description is required.")
    @Size(min = 10, message = "The description should be at least 10 characters")
    @Size(max = 2000, message = "The description cannot exceed 2000 characters")
    private String description;

    public @NotEmpty(message = "The name is required.") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "The name is required.") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "The category is required.") String getCategory() {
        return category;
    }

    public void setCategory(@NotEmpty(message = "The category is required.") String category) {
        this.category = category;
    }

    @Min(0)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public @Size(min = 10, message = "The description should be at least 10 characters") @Size(max = 2000, message = "The description cannot exceed 2000 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 10, message = "The description should be at least 10 characters") @Size(max = 2000, message = "The description cannot exceed 2000 characters") String description) {
        this.description = description;
    }
}
