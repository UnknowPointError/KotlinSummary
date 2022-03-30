package Year2022.Month03.Day28.Part3;

import Year2022.Month03.Day28.Part2.Animal;
import Year2022.Month03.Day28.Part2.Cat;

import java.util.ArrayList;
import java.util.List;

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/28 23:23 周一
@Description: 逆变
*/
public class GenericInversion {
    public static void main(String[] args) {
        List<? super Animal> animals = new ArrayList<>();
        animals.add(new Cat());
    }
}
