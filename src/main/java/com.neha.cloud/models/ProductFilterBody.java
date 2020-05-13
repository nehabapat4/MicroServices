package com.neha.cloud.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterBody {
    private List<UUID> listOfIds;
    private List<String> listOfNames;
    private List<String> listOfCategories;
}
