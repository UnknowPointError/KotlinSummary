package Year2022.Month03.Day18

import java.util.concurrent.BlockingQueue

// [2022/3/18 18:46] 
class FieldKotlin {
    val name: String
        get() = "Barry"

    var age: Int = 0 //
        get() = field
        set(value) {
            field = value
        }
    var time: String = "2022"
        set(value) {
            field = value
        }
        get() = field
}

lateinit var t : Sequence<Int>
fun main() {
    val sequence = sequenceOf(0,1,2,3,4,5, "Hello,World") // 创建 sequence
    val iterator = sequence.iterator() // 从序列中返回值得迭代器
    while (iterator.hasNext()) { // 判断迭代器是否有 下一个元素 true : 存在 false : 不存在
        println(iterator.next()) // 返回迭代中的下一个元素
    }
    FieldKotlin().apply {

    }
}