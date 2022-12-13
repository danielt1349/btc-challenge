package com.mcontigo.test.config

import feign.codec.Decoder
import feign.jackson.JacksonDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignClientConfiguration {
    @Bean
    fun feignDecoder(): Decoder {
        return JacksonDecoder()
    }
}
