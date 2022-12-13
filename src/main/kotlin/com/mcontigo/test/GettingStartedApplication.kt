package com.mcontigo.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@EnableJpaRepositories
@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class GettingStartedApplication

fun main(args: Array<String>) {
    runApplication<GettingStartedApplication>(*args)
}
