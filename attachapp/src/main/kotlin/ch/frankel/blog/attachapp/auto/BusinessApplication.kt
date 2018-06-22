package ch.frankel.blog.attachapp.auto

import ch.frankel.blog.attachapp.TransferController
import ch.frankel.blog.attachapp.TransferService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.*

@SpringBootApplication
class AttachApplication {
    @Bean
    fun controller() = TransferController(TransferService())
}

fun main(args: Array<String>) {
    runApplication<AttachApplication>(*args)
}
