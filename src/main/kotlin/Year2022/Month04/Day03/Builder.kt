package Year2022.Month04.Day03

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/3 22:12 周日
@Description: Builder模式
*/
class Builder private constructor() {
    var id: Int = 0
    var name: String = "Barry"
    var age: Int? = null

    constructor(init: Builder.() -> Unit) : this() {
        init()
    }

    fun id(init: Builder.() -> Int) = apply { id = init() }
    fun name(init: Builder.() -> String) = apply { name = init() }
    fun age(init: Builder.() -> Int) = apply { age = init() }
    fun build(): AndroidServer = AndroidServer(this)
}

class AndroidServer(val builder: Builder)


fun main() {
    val android = Builder {
        id { 5 }
        name { "Allen" }
        age { 12 }
    }.build()
    println(android.builder.age)
}
