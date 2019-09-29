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
    internal var r = Random()

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

    @JvmStatic
    fun rotateClockwise90(src: BufferedImage): BufferedImage {
        val width = src.width
        val height = src.height

        val dest = BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB)

        val graphics2D = dest.createGraphics()
        graphics2D.translate((height - width) / 2, (height - width) / 2)
        graphics2D.rotate(Math.PI / 2, (height / 2).toDouble(), (width / 2).toDouble())
        graphics2D.drawRenderedImage(src, null)

        return dest
    }

    @JvmStatic
    fun rotateClockwise(src: BufferedImage): BufferedImage {
        val width = src.width
        val height = src.height
        val dest = BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB)

        val graphics2D = dest.createGraphics()
        val transform = AffineTransform()
        transform.setToTranslation(((height - width) / 2).toDouble(),
                ((height - width) / 2).toDouble())

        transform.rotate(Math.toRadians(1.0), (width / 2).toDouble(),
                (height / 2).toDouble())
        graphics2D.transform = transform
        graphics2D.drawRenderedImage(src, null)

        return dest
    }

    @JvmStatic
    fun colorImage(image: BufferedImage): BufferedImage {
        val width = image.width
        val height = image.height
        val raster = image.raster

        for (xx in 0 until width) {
            for (yy in 0 until height) {
                val pixels = raster.getPixel(xx, yy, null as IntArray?)
                if (pixels[0] > 0) {
                    pixels[0] -= r.nextInt(5)
                    if (pixels[0] <= 0) {
                        pixels[0] = 255
                    }
                } else {
                    pixels[0] = 255
                }
                if (pixels[1] > 0) {
                    pixels[1] -= r.nextInt(5)
                    if (pixels[1] <= 0) {
                        pixels[1] = 255
                    }
                } else {
                    pixels[1] = 255
                }
                if (pixels[2] > 0) {
                    pixels[2] -= r.nextInt(5)
                    if (pixels[2] <= 0) {
                        pixels[2] = 255
                    }
                } else {
                    pixels[2] = 255
                }
                raster.setPixel(xx, yy, pixels)
            }
        }
        return image
    }

    @JvmStatic
    fun verticalFlip(img: BufferedImage): BufferedImage {
        val w = img.width
        val h = img.height
        val flippedImage = BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
        val g = flippedImage.createGraphics()
        g.drawImage(img, 0, 0, w, h, 0, h, w, 0, null)
        g.dispose()
        return flippedImage
    }

    @JvmStatic
    fun horizontalFlip(img: BufferedImage): BufferedImage {
        val w = img.width
        val h = img.height
        val flippedImage = BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
        val g = flippedImage.createGraphics()
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null)
        g.dispose()
        return flippedImage
    }
}