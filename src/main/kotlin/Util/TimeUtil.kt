package Util

import java.sql.Timestamp

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/3/22 19:44 周二
@Description: TimeUtil工具类
*/
object TimeUtil {
    fun getTime() : String {
        Timestamp(System.currentTimeMillis()).toLocalDateTime().apply {
            return "${year}年${month.value}月${dayOfMonth}日${hour}时${minute}分"
        }
    }
}