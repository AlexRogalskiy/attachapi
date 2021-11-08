package ch.frankel.blog.attachhack

import com.sun.tools.attach.VirtualMachine
import java.io.Closeable
import java.nio.charset.Charset


fun main(args: Array<String>) {
    Runtime.getRuntime()
        .exec("jps")
        .inputStream
        .bufferedReader(Charset.forName("UTF-8"))
        .lines()
        .map { it.split(" ").toTypedArray() }
        .filter { it.size > 1 && it[1].endsWith("BusinessApplicationKt") }
        .map { it[0] }
        .forEach { pid ->
            VirtualMachine.attach(pid).toCloseable().use {
                it.loadAgent(args[0])
            }
        }
}

fun VirtualMachine.toCloseable() = CloseableVirtualMachine(this)

class CloseableVirtualMachine(private val vm: VirtualMachine) : Closeable {
    fun loadAgent(arg: String) {
        vm.loadAgent(arg)
    }

    override fun close() {
        vm.detach()
    }
}