package Year2022.Month03.Day25.Part4

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/25 2:59 周五
@Description: 委托属性的学习
*/
class User(val id: Int) {
    var name: String by DatabaseDelegate("name", id) // 使用委托属性
    var password: String by DatabaseDelegate("password", id) // 使用委托属性
}

fun main() {
    val tony = User(2)
    println("tony.password = ${tony.password}")
    println("-----------------------")
    tony.password = "P@ssword"
    println("-----------------------")
    println("tony.password = ${tony.password}")


}