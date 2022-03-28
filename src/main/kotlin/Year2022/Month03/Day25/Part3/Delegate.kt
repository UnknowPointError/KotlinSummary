package Year2022.Month03.Day25.Part3

import kotlin.reflect.KProperty

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/25 2:36 周五
@Description: 委托属性的学习
*/
class Delegate {
    operator fun getValue(thisRef: Any?,property : KProperty<*>) : String{
        return "${property.name} : ${thisRef}"
    }

    operator fun setValue(thisRef: Any?,property: KProperty<*>,value: String) {
        println("${property.name} = $value")
    }
}