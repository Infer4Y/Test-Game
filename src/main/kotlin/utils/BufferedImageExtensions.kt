package utils

import java.awt.AlphaComposite
import java.awt.Color
import java.awt.geom.AffineTransform
import java.awt.image.AffineTransformOp
import java.awt.image.BufferedImage
import java.util.*

private var r = Random()

fun BufferedImage.scale(scale: Double): BufferedImage {
    val w = this.width
    val h = this.height
    // Create a new image of the proper size
    val w2 = (w * scale).toInt()
    val h2 = (h * scale).toInt()
    val after = BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB)
    val scaleInstance = AffineTransform.getScaleInstance(scale, scale)
    val scaleOp = AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_NEAREST_NEIGHBOR)

    scaleOp.filter(this, after)
    return after
}

fun BufferedImage.dye(color: Color): BufferedImage {
    val w = this.width
    val h = this.height
    val dyed = BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
    val g = dyed.createGraphics()
    g.drawImage(this, 0, 0, null)
    g.composite = AlphaComposite.SrcAtop
    g.color = color
    g.fillRect(0, 0, w, h)
    g.dispose()
    return dyed
}

fun BufferedImage.joinWith(img: BufferedImage): BufferedImage {
    val width = this.width
    val height = this.height
    val newImage = BufferedImage(width, height,
            BufferedImage.TYPE_INT_ARGB)
    val g2 = newImage.createGraphics()
    g2.drawImage(this, null, 0, 0)
    g2.drawImage(img, null, 0, 0)
    g2.dispose()
    return newImage
}

fun BufferedImage.rotateClockwise90(): BufferedImage {
    val width = this.width
    val height = this.height

    val dest = BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB)

    val graphics2D = dest.createGraphics()
    graphics2D.translate((height - width) / 2, (height - width) / 2)
    graphics2D.rotate(Math.PI / 2, (height / 2).toDouble(), (width / 2).toDouble())
    graphics2D.drawRenderedImage(this, null)

    return dest
}

fun BufferedImage.rotateClockwise(): BufferedImage {
    val width = this.width
    val height = this.height
    val dest = BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB)

    val graphics2D = dest.createGraphics()
    val transform = AffineTransform()
    transform.setToTranslation(((height - width) / 2).toDouble(),
            ((height - width) / 2).toDouble())

    transform.rotate(Math.toRadians(1.0), (width / 2).toDouble(),
            (height / 2).toDouble())
    graphics2D.transform = transform
    graphics2D.drawRenderedImage(this, null)

    return dest
}

fun BufferedImage.colorImage(): BufferedImage {
    val width = this.width
    val height = this.height
    val raster = this.raster

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
    return this
}

fun BufferedImage.flipVertically(): BufferedImage {
    val w = this.width
    val h = this.height
    val flippedImage = BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
    val g = flippedImage.createGraphics()
    g.drawImage(this, 0, 0, w, h, 0, h, w, 0, null)
    g.dispose()
    return flippedImage
}

fun BufferedImage.horizontalFlip(): BufferedImage {
    val w = this.width
    val h = this.height
    val flippedImage = BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
    val g = flippedImage.createGraphics()
    g.drawImage(this, 0, 0, w, h, w, 0, 0, h, null)
    g.dispose()
    return flippedImage
}