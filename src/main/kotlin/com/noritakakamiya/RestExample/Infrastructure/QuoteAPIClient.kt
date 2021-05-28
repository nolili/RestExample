package com.noritakakamiya.RestExample.Infrastructure

import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class QuoteAPIClient(private val restTemplate: RestTemplate) : APIClient {
    override fun getQuote(): Quote {
        println(restTemplate.uriTemplateHandler)
        return restTemplate.getForObject("/api/random", Quote::class.java) ?: throw RuntimeException()
    }
}
