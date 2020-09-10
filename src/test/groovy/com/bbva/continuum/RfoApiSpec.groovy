package com.bbva.continuum

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class RfoApiSpec extends Specification {

    @Inject
    EmbeddedApplication application

    void 'test it works'() {
        expect:
        application.running
    }

}