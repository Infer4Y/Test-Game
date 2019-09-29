package client

import common.block.Block
import common.block.BlockOre
import common.item.Item
import common.item.ItemBlock
import common.item.ItemIngot
import utils.FileUtils
import utils.joinWith
import utils.scale
import java.awt.image.BufferedImage
import java.io.IOException
import java.util.*
import javax.imageio.ImageIO

// TODO: This class needs a massive rewrite.
class Textures {
    private val textures4 = HashMap<String, BufferedImage>()
    private val textures3 = HashMap<String, BufferedImage>()
    private val textures2 = HashMap<String, BufferedImage>()
    private val textures1 = HashMap<String, BufferedImage>()

    private var placeholder4: BufferedImage? = null
    private var placeholder3: BufferedImage? = null
    private var placeholder2: BufferedImage? = null
    private var placeholder1: BufferedImage? = null

    fun init(items: HashMap<String, Item>, blocks: HashMap<String, Block>) {
        try {
            ImageIO.read(this.javaClass.classLoader.getResource("tex/placeholder.png"))?.let {
                // TODO: Make sure that these aren't cascading and messing up scaling.
                placeholder4 = it.scale(4.0)
                placeholder3 = it.scale(3.0)
                placeholder2 = it.scale(2.0)
                placeholder1 = it.scale(1.0)
            }
        }catch (i: IOException) {
            i.printStackTrace()
        }

        try {
            slot = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/slot.png")!!), 1.0)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        for (i in items.values) {
            register1(i)
            register2(i)
            register3(i)
            register4(i)
        }
        for (i in blocks.values) {
            register1(i)
            register2(i)
            register3(i)
            register4(i)
        }
    }

    fun getTexture1(name: String): BufferedImage {
        return (textures1 as java.util.Map<String, BufferedImage>).getOrDefault(name, placeholder1)
    }

    fun getTexture2(name: String): BufferedImage {
        return (textures2 as java.util.Map<String, BufferedImage>).getOrDefault(name, placeholder2)
    }

    fun getTexture3(name: String): BufferedImage {
        return (textures3 as java.util.Map<String, BufferedImage>).getOrDefault(name, placeholder3)
    }

    fun getTexture4(name: String): BufferedImage {
        return (textures4 as java.util.Map<String, BufferedImage>).getOrDefault(name, placeholder4)
    }

    private fun register4(block: Block) {
        try {
            if (block is BlockOre) {
                textures4[block.name] = FileUtils.scale1(FileUtils.joinBufferedImage(ImageIO.read(
                        this.javaClass.classLoader.getResource("tex/blocks/stone.png")!!), FileUtils.dye(ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/ore_overlay.png")!!), block.getColor())), 4.0
                )
            } else {
                textures4[block.name] = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/" + block.name + ".png")!!), 4.0)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun register4(vararg block: Block) {
        for (b in block) {
            register4(b)
        }
    }

    private fun register3(block: Block) {
        try {
            if (block is BlockOre) {
                val overlay = ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/ore_overlay.png"))
                ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/stone.png"))?.let {
                    textures3[block.name] = it.joinWith(overlay).scale(3.0)
                }
            } else {
                ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/" + block.name + ".png"))?.let {
                    textures3[block.name] = it.scale(3.0)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun register3(vararg block: Block) {
        for (b in block) {
            register3(b)
        }
    }

    private fun register2(block: Block) {
        try {
            if (block is BlockOre) {
                val overlay = ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/ore_overlay.png"))
                ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/stone.png"))?.let {
                    textures2[block.name] = it.joinWith(overlay).scale(2.0)
                }
            } else {
                ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/" + block.name + ".png"))?.let {
                    textures2[block.name] = it.scale(2.0)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun register2(vararg blocks: Block) {
        for (block in blocks) {
            register2(block)
        }
    }

    private fun register1(block: Block) {
        try {
            if (block is BlockOre) {
                val overlay = ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/ore_overlay.png"))
                ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/stone.png"))?.let {
                    textures1[block.name] = it.joinWith(overlay).scale(1.0)
                }
            } else {
                ImageIO.read(this.javaClass.classLoader.getResource("tex/blocks/" + block.name + ".png"))?.let {
                    textures1[block.name] = it.scale(1.0)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun register1(vararg block: Block) {
        for (b in block) {
            register1(b)
        }
    }

    private fun register4(block: Item) {
        try {
            if (block is ItemBlock) {
                //textures4.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 4.0));
            } else if (block is ItemIngot) {
                textures4[block.name] = FileUtils.scale1(
                        FileUtils.joinBufferedImage(
                                FileUtils.dye(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot.png")!!), block.getColor()),
                                ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot_1.png")!!)
                        ), 4.0
                )
            } else {
                textures4[block.name] = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/" + block.name + ".png")!!), 4.0)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun register4(vararg blocks: Item) {
        for (block in blocks) {
            if (block is ItemBlock) {
            } else {
                register4(block)
            }
        }
    }

    private fun register3(block: Item) {
        try {
            if (block is ItemBlock) {
                //textures3.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 3.0));
            } else if (block is ItemIngot) {
                textures3[block.name] = FileUtils.scale1(
                        FileUtils.joinBufferedImage(
                                FileUtils.dye(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot.png")!!), block.getColor()),
                                ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot_1.png")!!)
                        ), 3.0
                )
            } else {
                textures3[block.name] = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/" + block.name + ".png")!!), 3.0)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun register3(vararg blocks: Item) {
        for (block in blocks) {
            if (block is ItemBlock) {
            } else {
                register3(block)
            }
        }
    }

    private fun register2(block: Item) {
        try {
            if (block is ItemBlock) {
                //textures2.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 2.0));
            } else if (block is ItemIngot) {
                textures2[block.name] = FileUtils.scale1(
                        FileUtils.joinBufferedImage(
                                FileUtils.dye(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot.png")!!), block.getColor()),
                                ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot_1.png")!!)
                        ), 2.0
                )
            } else {
                textures2[block.name] = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/" + block.name + ".png")!!), 2.0)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun register2(vararg blocks: Item) {
        for (block in blocks) {
            register2(block)
        }
    }

    private fun register1(block: Item) {
        try {
            if (block is ItemBlock) {
                //textures1.put(block.getName(), FileUtils.scale1(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tex/blocks/" + block.getName() + ".png"))), 1.0));
            } else if (block is ItemIngot) {
                textures1[block.name] = FileUtils.scale1(
                        FileUtils.joinBufferedImage(
                                FileUtils.dye(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot.png")!!), block.getColor()),
                                ImageIO.read(this.javaClass.classLoader.getResource("tex/items/ingot_1.png")!!)
                        ), 1.0
                )
            } else {
                textures1[block.name] = FileUtils.scale1(ImageIO.read(this.javaClass.classLoader.getResource("tex/items/" + block.name + ".png")!!), 1.0)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun register1(vararg blocks: Item) {
        for (block in blocks) {
            register1(block)
        }
    }

    companion object {
        lateinit var slot: BufferedImage
    }
}
