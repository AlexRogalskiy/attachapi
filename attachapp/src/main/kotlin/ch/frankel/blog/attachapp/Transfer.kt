package ch.frankel.blog.attachapp

import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
class TransferController(private val service: TransferService) {

    @GetMapping("/account/{from}/transfer")
    @ResponseStatus(value = HttpStatus.OK)
    fun transfer(@PathVariable from: String, @RequestParam to: String, @RequestParam amount: Double) {
        service.transfer(from, to, amount)
    }
}

class TransferService {
    fun transfer(from: String, to: String, amount: Double) {
        println("Succesfully transferred $amount from $from to $to")
    }
}