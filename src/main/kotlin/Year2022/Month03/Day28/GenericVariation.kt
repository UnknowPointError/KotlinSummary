package Year2022.Month03.Day28

import Year2022.Month03.Day28.Part2.Animal
import Year2022.Month03.Day28.Part2.Cat

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/28 23:17 周一
@Description: 协变
*/
class GenericVariation

fun main() {
    var animals : List<Animal> = ArrayList()
    val cats = ArrayList<Cat>()
    animals = cats
    // 没报错，其实在Kotlin中List的源码使用了out关键字，就相当于Java的上界通配符。
    // 分析源码发现@UnsafeVariance目的为了打破out使用的限制，否则编译报错。
}