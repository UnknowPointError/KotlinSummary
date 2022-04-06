package Year2022.Month04.Day03

import kotlin.properties.Delegates

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/3 22:33 周日
@Description: Observer观察者模式
*/
interface Listener {
    fun onTextChanged(oldText: String, newText: String)
}

class TextChangedListener1 : Listener {
    override fun onTextChanged(oldText: String, newText: String) {
        println("Text is changed from $oldText to $newText")
    }
}

class TextChangedListener2 : Listener {
    override fun onTextChanged(oldText: String, newText: String) {
        println("newText value is $newText")
    }
}

class TextView {
    val listeners = mutableListOf<Listener>()
    var text: String by Delegates.observable("Hello") { _, old, new ->
        listeners.random().onTextChanged(old, new)
    }
}

fun main() {
    val textView = TextView().apply {
        listeners.add(TextChangedListener1())
        listeners.add(TextChangedListener2())
    }
    with(textView) {
        text = "Hi"
    }
    println("textView.text : ${textView.text}")
}

