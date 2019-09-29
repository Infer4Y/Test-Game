package utils

import java.awt.AlphaComposite
import java.awt.Color
import java.awt.geom.AffineTransform
import java.awt.image.AffineTransformOp
import java.awt.image.BufferedImage
import java.io.File
import java.net.URL
import java.util.*

object FileUtils {
    private var r = Random()

    @JvmStatic
    fun getFileFromResources(fileName: String): File? {

        val classLoader = FileUtils::class.java.javaClass.classLoader
        val resource: URL?
        try {
            resource = classLoader.getResource(fileName)
            return if (resource == null) {
                throw IllegalArgumentException("file is not found!")
            } else {
                File(resource.file)
            }
        } catch (e: Exception) {
        }

        return null

    }

    @JvmStatic
    fun dye(image: BufferedImage, color: Color): BufferedImage {
        val w = image.width
        val h = image.height
        val dyed = BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
        val g = dyed.createGraphics()
        g.drawImage(image, 0, 0, null)
        g.composite = AlphaComposite.SrcAtop
        g.color = color
        g.fillRect(0, 0, w, h)
        g.dispose()
        return dyed
    }

    @JvmStatic
    fun joinBufferedImage(img1: BufferedImage, img2: BufferedImage): BufferedImage {
        val width = img1.width
        val height = img1.height
        val newImage = BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB)
        val g2 = newImage.createGraphics()
        g2.drawImage(img1, null, 0, 0)
        g2.drawImage(img2, null, 0, 0)
        g2.dispose()
        return newImage
    }

    @JvmStatic
    fun getResourceFolderFiles(folder: String): Array<File>? {
        val loader = Thread.currentThread().contextClassLoader
        val url = loader.getResource(folder)
        val path = url!!.path
        return File(path).listFiles()
    }

    @JvmStatic
    fun scale1(before: BufferedImage, scale: Double): BufferedImage {
        val w = before.width
        val h = before.height
        // Create a new image of the proper size
        val w2 = (w * scale).toInt()
        val h2 = (h * scale).toInt()
        val after = BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB)
        val scaleInstance = AffineTransform.getScaleInstance(scale, scale)
        val scaleOp = AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_NEAREST_NEIGHBOR)

        scaleOp.filter(before, after)
        return after
    }
}