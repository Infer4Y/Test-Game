package utils

import java.io.File
import java.net.URL

fun String.getAsFile(): File? {

    val classLoader = FileUtils::class.java.javaClass.classLoader
    val resource: URL?
    try {
        resource = classLoader.getResource(this)
        return if (resource == null) {
            throw IllegalArgumentException("file is not found!")
        } else {
            File(resource.file)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun String.getAsResourceFolder(): Array<File>? {
    val loader = Thread.currentThread().contextClassLoader
    val url = loader.getResource(this)
    val path = url!!.path
    return File(path).listFiles()
}