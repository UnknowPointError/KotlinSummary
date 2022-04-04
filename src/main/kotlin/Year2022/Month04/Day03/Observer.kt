package Year2022.Month04.Day03

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/3 22:33 周日
@Description: Observer观察者模式
*/
class Observer {
}

interface Listener {
    fun onTextChanged(oldText : String, newText: String)
}