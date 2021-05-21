package com.example

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class TestController {

    final EntityOneRepo repo

    TestController(EntityOneRepo repo) {
        this.repo = repo
    }
    @Get
    HttpStatus test() {
        HttpStatus.OK
    }
}
