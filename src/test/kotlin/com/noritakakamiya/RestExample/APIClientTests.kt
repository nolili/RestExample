package com.noritakakamiya.RestExample

import com.noritakakamiya.RestExample.Infrastructure.DogAPIClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess
import org.springframework.web.client.RestTemplate

@SpringBootTest
class APIClientTests {
    @Autowired
    lateinit var restTemplate: RestTemplate

    @Test
    fun testExample() {
        val server = MockRestServiceServer.bindTo(restTemplate).build()
        server.expect(MockRestRequestMatchers.requestTo("https://quoters.apps.pcfone.io/api/random")).andRespond(
            withSuccess(
                "{\"type\":\"success\",\"value\":{\"id\":12,\"quote\":\"@springboot with @springframework is pure productivity! Who said in #java one has to write double the code than in other langs? #newFavLib\"}}",
                MediaType.APPLICATION_JSON_UTF8
            )
        )
        val client = DogAPIClient(restTemplate)
        val result = client.getDog()

        assertEquals(12, result.value.id)

        server.verify()
    }
}
