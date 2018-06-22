package ch.frankel.blog.attachagent

import java.io.ByteArrayOutputStream
import java.lang.instrument.ClassDefinition
import java.lang.instrument.Instrumentation

class Handle

fun agentmain(args: String?, instrumentation: Instrumentation) {
    val clazz = Class.forName("ch.frankel.blog.attachapp.TransferService")
    val inputStream = Handle::class.java.classLoader.getResourceAsStream("TransferService.class")
    val baos = ByteArrayOutputStream()
    inputStream.use { it.copyTo(baos) }
    instrumentation.redefineClasses(ClassDefinition(clazz, baos.toByteArray()))
}