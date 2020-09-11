package com.bbva.continuum

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
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

    @Inject
    @Client("/")
    RxHttpClient client

    void "test hello world response"() {
        when:
        HttpRequest request = HttpRequest.GET('/greetings/USER')
        String rsp = client.toBlocking().retrieve(request)

        then:
        rsp == "Hello USER, How are you doing?"
    }




}