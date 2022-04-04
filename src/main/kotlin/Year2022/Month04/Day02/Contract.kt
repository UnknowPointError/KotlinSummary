package Year2022.Month04.Day02

import kotlin.contracts.contract

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/2 19:41 周六
@Description: 智能推断
*/

@OptIn(kotlin.contracts.ExperimentalContracts::class) // 必须需要此注解，避免Error 实验性...
private fun String?.isNotNull(): Boolean {
    contract {
        returns(true) implies (this@isNotNull != null)
    }
    return this != null
}

class Contract {
    fun printLength(str: String? = null) {
        if (str.isNotNull()) {
            println(str.length)
        }
    }
}

fun main() {
    Contract().printLength()
}