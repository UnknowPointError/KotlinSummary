package Year2022.Month03.Day28.Part1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/28 16:44 周一
@Description: 反射获得泛型类型
*/
public class Generic2 {
    public static void main(String[] args) {
        GenericChild child = new GenericChild();
        child.printType();
    }
}

class Father<T> {
}

class GenericChild extends Father<String> {
    public void printType() {
        Type genType = getClass().getGenericSuperclass();
        System.out.println(genType);
        Type params = ((ParameterizedType)genType).getActualTypeArguments()[0];
        System.out.println(params);
    }
}
