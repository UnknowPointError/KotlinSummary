package Year2022.Month03.Day28.Part2;

import java.util.ArrayList;
import java.util.List;

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/28 22:26 周一
@Description: 型变
*/
public class GenericVariation {
    public static void main(String[] args) {
        List<? extends Animal> animals = new ArrayList<>();
        // List<Cat> 变成了 List<? extends Animal>的子类型，即animals变成了可以放入任何Animal及其子类的List
        animals = new ArrayList<Cat>();
    }
}
