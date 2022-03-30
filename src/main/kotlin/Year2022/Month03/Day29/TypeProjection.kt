package Year2022.Month03.Day29

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/29 10:38 周二
@Description: 类型投影
*/
class TypeProjection

fun main() {
    val list1: MutableList<String> = mutableListOf()
    list1.add("Hello")
    list1.add("World")
    var list2: MutableList<out String> = mutableListOf("Hello,World")
//    list2.add("Hello") Compile Error.
    val list3: MutableList<in String> = mutableListOf("Barry Allen")
    list3.add("Gao")
    list3.add("Yu")
    lateinit var list4: MutableList<String>
    list2 = list4
//    由于list2和list3分别表示一个受限制的MutableList 其主要作用是对参数进行限定，避免不安全操作
}