package Year2022.Month03.Day25.Part1

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/25 1:50 周五
@Description: by关键字的学习-->BaseImpl实现接口的委托的类
*/
class BaseImpl(val number: Int) : Base {
    override fun print() {
        println(number)
    }
}