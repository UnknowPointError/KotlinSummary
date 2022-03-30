package Year2022.Month03.Day28

import Year2022.Month03.Day28.Part2.Animal
import Year2022.Month03.Day28.Part2.Cat
import java.util.ArrayList

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/29 10:05 周二
@Description: 逆变
*/
class GenericInversion

fun main() {
    val animals: MutableList<in Animal> = ArrayList()
    animals.add(Cat())
}