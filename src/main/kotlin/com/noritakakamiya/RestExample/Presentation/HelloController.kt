package com.noritakakamiya.RestExample.Presentation

import com.noritakakamiya.RestExample.Service.DogAPIService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController(private val apiService: DogAPIService) {
    @GetMapping("/")
    @ResponseBody
    fun hello(): String {
        return apiService.fetch().toString()
    }
}
