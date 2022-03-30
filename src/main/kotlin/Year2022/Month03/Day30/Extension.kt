package Year2022.Month03.Day30.Reflect

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/30 20:20 周三
@Description: 扩展属性
*/
class Extension
class Bar1(val x: Int)
class Bar2(val x: Int, val y: String)

val Extension.x: Int
    get() = 1
val y: Int
    get() = 2

fun main() {
    // Kotlin中没有成员变量的概念，只有属性的概念
    val extension = Extension()
    val bar1 = Bar1(1)
    val property = Bar1::x //获取成员属性
    println(Extension::x) // 类名::属性 来获取扩展属性的引用
    println(Extension::x.get(extension))
    println(Extension::x.getValue(extension, Extension::x))
    println(::y.name)   // ::属性 来获取属性的引用
    println("==============")
    println(property.call(bar1))
    println(property.get(bar1))
    println(property.getter.call(bar1))
}