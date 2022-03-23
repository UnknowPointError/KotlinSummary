package Year2022.Month03.Day21;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/3/21 18:16 周一
@Description: BlockingQueen Div
*/

public class Div extends Thread {

    public static BlockingQueue<Context> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {
                Context ctx = bq.take();
                ctx.r = ctx.r / 2;
                System.out.println(ctx.org + "=" + ctx.r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
