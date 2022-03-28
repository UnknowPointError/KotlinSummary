package Year2022.Month03.Day28.Part1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/28 16:38 周一
@Description: 匿名内部类获取泛型参数的类型
*/
public class Generic {

    static class InnerClass<T> {

    }

    public static void main(String[] args) {
        InnerClass<Integer> innerClass = new InnerClass<Integer>() {
        };
        Type typeClass = innerClass.getClass().getGenericSuperclass();
        System.out.println(typeClass);
        if(typeClass instanceof ParameterizedType) {
            Type actualType = ((ParameterizedType)typeClass).getActualTypeArguments()[0];
            System.out.println(actualType);
        }
    }
}
