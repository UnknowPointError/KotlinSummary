package Year2022.Month03.Day25.Part4

import java.lang.Exception

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/25 2:52 周五
@Description: 找不到记录异常
*/
class NoRecordFoundException(id: Int) : Exception("No record found for id $id") {
}