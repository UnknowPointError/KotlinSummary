package MineBBS.NetWork

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/18 20:53 周一
@Description: 
*/
//22  1 ,10 ,11
//123 1 ,10 ,100-109, 11,  110-119, 12, 120-123
fun main() {
    val input = readLine()?.toInt()
    val list = mutableListOf<Any>()
    input?.let { number ->
        if (number > 50000 || number <= 0)
            return@let
        else {
            when (number.toString().length) {
                1 -> {
                    for (i in 1..number) {
                        list.add(i)
                    }
                }

                2 -> {
                    for (i in 1..number) {
                        if (i % 10 == 0 || i == 1) {

                        }
                    }
                }
            }
        }
        println(list)
    }
}