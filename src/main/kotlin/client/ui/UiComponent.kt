package client.ui

abstract class UiComponent () {
    var x : Int = 0
    var y : Int = 0
    var xBound : Int = 32
    var yBound : Int = 32

    constructor(x:Int, y:Int) : this() {
        this.x = x
        this.y = y
        this.xBound = 32
        this.yBound = 32
    }

    constructor(x:Int, y:Int, xBound:Int, yBound:Int) : this() {
        this.x = x
        this.y = y
        this.xBound = xBound
        this.yBound = yBound
    }

    abstract fun mouseLeftClick()
    abstract fun mouseMidClick()
    abstract fun mouseRightClick()

    fun setBounds(xBound:Int, yBound:Int){
        this.xBound = xBound
        this.yBound = yBound
    }
}