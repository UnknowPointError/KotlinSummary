package Year2022.Month03.Day31;

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/31 0:42 周四
@Description: 
*/
public class Extension {
    private String name = "Barry";

    public static void main(String[] args) {
        Extension extension;
        extension = new Extension();
        System.out.println(extension.name.getClass().getName());
        int x = false ? 5 : 6;
        System.out.println(x);
    }
}
