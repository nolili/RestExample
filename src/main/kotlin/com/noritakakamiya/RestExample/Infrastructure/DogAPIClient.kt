package com.noritakakamiya.RestExample.Infrastructure

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.lang.RuntimeException


@Repository
class DogAPIClient(private val restTemplate: RestTemplate): APIClient {
    override fun getDog(): Quote {
        println(restTemplate.uriTemplateHandler)
        return restTemplate.getForObject("/api/random", Quote::class.java) ?: throw RuntimeException()
    }
}
