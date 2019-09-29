package client.threaded

//TODO: This should be associated with ClientGame and do the drawing.
class ThreadRenderer : Thread() {

    private fun render() {
        /*BufferStrategy bufferstrategy = Game.instance.getBufferStrategy ();

        if (bufferstrategy == null) {
            Game.instance.createBufferStrategy(4);
            return;
        }

        Graphics2D g = (Graphics2D) bufferstrategy.getDrawGraphics();

        g.setColor (Color.BLACK);
        g.fillRect (0, 0, Game.instance.getWidth(), Game.instance.getHeight());
        g.dispose ();
        bufferstrategy.show();
         */
    }

    @Synchronized
    override fun start() {
        super.start()
    }

    override fun run() {
        //while (Game.isRunning) {
        //    render();
        //}
    }
}
