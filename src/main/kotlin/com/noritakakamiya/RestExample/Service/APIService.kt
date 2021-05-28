package com.noritakakamiya.RestExample.Service

import com.noritakakamiya.RestExample.Infrastructure.APIClient
import com.noritakakamiya.RestExample.Infrastructure.Quote
import org.springframework.stereotype.Service

interface APIService {
    fun fetch(): Quote
}

@Service
class DogAPIService(private val apiClient: APIClient) : APIService {
    override fun fetch(): Quote {
        return apiClient.getQuote()
    }
}
