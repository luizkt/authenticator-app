package br.com.lkt.authenticator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@SpringBootApplication
@EnableFeignClients
private class AuthenticatorApplication

fun main(args: Array<String>) {
	runApplication<AuthenticatorApplication>(*args)
}

@Bean
fun taskExecutor(): Executor? {
	val executor = ThreadPoolTaskExecutor()
	executor.corePoolSize = 25
	executor.maxPoolSize = 50
	executor.setQueueCapacity(500)
	executor.setThreadNamePrefix("Authenticator-")
	executor.initialize()
	return executor
}