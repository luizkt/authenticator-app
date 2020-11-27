package br.com.lkt.authenticator.integration.feign.config

import feign.Logger
import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import feign.okhttp.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType

@Configuration
class FeignConfig {

    @Bean
    fun feignLoggerLevel(): Logger.Level? {
        return Logger.Level.FULL
    }

    @Bean
    fun errorDecoder(): ErrorDecoder.Default {
        return feign.codec.ErrorDecoder.Default()
    }

    @Bean
    fun client(): OkHttpClient? {
        return OkHttpClient()
    }

    @Bean
    fun requestInterceptor(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate ->
            requestTemplate.header("Accept", MediaType.APPLICATION_JSON.toString())
        }
    }
}