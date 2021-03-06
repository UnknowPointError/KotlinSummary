package Year2022.Month03.Day30

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/30 18:22 周三
@Description: 星号投影（用来表示：“不知道关于泛型参数fb的任何类型”）
*/
class StarProjections {
    // MutableList<*>表示的是MutableList<out Any?>
    fun printListOne(list: MutableList<out Any?>) {
        println(list)
    }

    fun printListTwo(list: MutableList<*>) {
        println(list)
    }
}

fun main() {

    StarProjections().apply {
        val list1 = mutableListOf<String>()
        list1.add("Hello")
        list1.add("World")
        printListOne(list1)
        printListTwo(list1)

        val list2 = mutableListOf<Int>()
        list2.add(123)
        list2.add(456)
        printListOne(list2)
        printListTwo(list2)

        val list3: MutableList<out Any?> = mutableListOf(1)
        val list4: MutableList<*> = list3
        println(list4)
    }
}

