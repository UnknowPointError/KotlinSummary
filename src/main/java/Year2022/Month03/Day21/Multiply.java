package Year2022.Month03.Day21;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/21 18:15 周一
@Description: BlockingQueen Multiply
*/

public class Multiply extends Thread {

    public static BlockingQueue<Context> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {
                Context ctx = bq.take();
                ctx.r = ctx.B * ctx.r;
                Div.bq.add(ctx);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
