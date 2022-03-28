package Year2022.Month03.Day25.Part4

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/25 2:45 周五
@Description: 委托属性的学习
*/
class DatabaseDelegate<in R, T>(private val field: String, private val id: Int) : ReadWriteProperty<R, T> {
    override fun getValue(thisRef: R, property: KProperty<*>): T = queryForValue(field, id) as T


    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        update(field, id, value)
    }

    val data = arrayOf<MutableMap<String, Any?>>(
        mutableMapOf(
            "id" to 1,
            "name" to "Tony",
            "password" to "123456"
        ),
        mutableMapOf(
            "id" to 2,
            "name" to "Monica",
            "password" to "123456"
        )
    )

    private fun queryForValue(field: String, id: Int): Any {
        val value = data.firstOrNull { it["id"] == id }?.get(field) ?: throw NoRecordFoundException(id)
        println("loaded value $value for field \"$field\" of record id.")
        return value
    }
    private fun update(field: String, id: Int, value: Any?) {
        println("updating field \"$field\" of record $id to value $value.")
        data.firstOrNull { it["id"] == id }?.put(field,value) ?: throw NoRecordFoundException(id)
    }
}