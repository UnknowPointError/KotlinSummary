package Year2022.Month03.Day22

import java.util.*

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/22 19:03 周二
@Description: inline、noinline、crossinline
*/
class InlineLearn {
    inline fun inlineFunction(block: Sequence<Any>.() -> Unit) {
        val startTime = System.currentTimeMillis()
        val sequence = sequenceOf("Barry", 6.66, 3.14, 2004)
        block(sequence)
        val endTime = System.currentTimeMillis()
        println("Inline function take ${endTime - startTime} ms.")
    }

    fun withoutInlineFunction(block: MutableMap<String, Char>.() -> Unit) {
        val startTime = System.currentTimeMillis()
        val mutableMap = mutableMapOf(
            "Barry" to 'A',
            "Allen" to 'B',
            "Winner" to 'C'
        )
        block(mutableMap)
        val endTime = System.currentTimeMillis()
        println("Without inline function take ${endTime - startTime} ms.")
    }

    inline fun noinlineFunction(
        block: List<Double>.() -> Unit,
        noinline block2: String.() -> Unit,
        crossinline block3: CharSequence.() -> Unit,
    ) {
        val list = listOf<Double>(1.22, 2.1, 3.999, 4.33, 5.22)
        val name = "Barry"
        val charSequence = sequenceOf(1, 2, 3, 4, 5, 'A') as CharSequence
        block(list)
        block2(name)
        block3(charSequence)
        println("End")
    }
}
fun main() {
    InlineLearn().apply {
        inlineFunction {
            println("Hello,World! Inline Function.")
            repeat(10000) {
                print("")
            }
        }
        withoutInlineFunction {
            println("Hello,World! Without Function.")
            repeat(1000) {
                print("")
            }
        }
        noinlineFunction({
            println("Hello,World! inline Function.")
            repeat(1000) {
                print("")
            }
            return // inline支持lambda函数外部函数的返回
        }, {
            println("Hello,World! noinline Function.")
            repeat(1000) {
                print("")

            }
            return@noinlineFunction
//            return 错误，noinline不支持外部函数的返回,并且不会优化内存，效率高
        }, {
            println("Hello,World! crossInline Function.")
            repeat(1000) {
                print("")
            }
            return@noinlineFunction
//            return 错误，crossInline不支持外部函数的返回，优化内存，效率降低
        })
    }
}