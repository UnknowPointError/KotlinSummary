package Year2022.Month03.Day25.Part3

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/25 2:39 周五
@Description: 委托属性的学习
*/
class User {
    var name: String by Delegate()
    var password: String by Delegate()
}

fun main() {
    val user = User()
    println(user.name)
    user.name = "Tony"
    println(user.password)
    user.password = "Tony"
}