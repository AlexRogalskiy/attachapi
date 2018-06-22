package ch.frankel.blog.attachhack

import com.sun.tools.attach.VirtualMachine

fun main(args: Array<String>) {
    with(VirtualMachine.attach(args[0])) {
        try {
            loadAgent(args[1])
        } finally {
            detach()
        }
    }
}