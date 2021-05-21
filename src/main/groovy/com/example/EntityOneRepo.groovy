package com.example

import io.micronaut.data.annotation.Id
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

import javax.validation.Valid
import javax.validation.constraints.NotNull

@JdbcRepository(dialect = Dialect.H2)
interface EntityOneRepo extends CrudRepository<EntityOne,UUID> {
    void updateEntityTwo(@Id UUID id, @NotNull @Valid EntityTwo entityTwo)
}
