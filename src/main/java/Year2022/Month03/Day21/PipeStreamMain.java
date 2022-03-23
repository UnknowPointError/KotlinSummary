package Year2022.Month03.Day21;

import java.text.MessageFormat;

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/21 18:16 周一
@Description: PipeStream and BlockingQueen
*/
public class PipeStreamMain {

    public static void main(String[] args) throws InterruptedException {
        //启动线程之后等待数据
        new Plus().start();
        new Multiply().start();
        new Div().start();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Context ctx = new Context();
                ctx.B = i;
                ctx.C = j;
                ctx.org = MessageFormat.format("({0}+{1})*{0}/2", ctx.B, ctx.C);
                Plus.bq.add(ctx);
            }
        }
    }
}
