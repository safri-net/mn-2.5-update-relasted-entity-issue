package com.example

import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@MappedEntity
class EntityOne {

    @Id
    @AutoPopulated
    UUID id

    @NotBlank
    String name

    @NotNull
    EntityTwo entityTwo

}
