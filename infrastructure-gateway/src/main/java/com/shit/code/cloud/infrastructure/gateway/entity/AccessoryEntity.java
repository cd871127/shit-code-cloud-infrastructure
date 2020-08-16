package com.shit.code.cloud.infrastructure.gateway.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AccessoryEntity {
    private String name;

    private String configClassName;

    private List<String> configFields;
}
