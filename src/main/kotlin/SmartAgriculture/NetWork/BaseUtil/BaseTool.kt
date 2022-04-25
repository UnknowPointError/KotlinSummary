package SmartAgriculture.NetWork.BaseUtil

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.sql.Timestamp
import java.util.Date


/* List[0] == UserName List[1] == PassWord */
fun generateTokenInfo(): List<String> {
    val adp_type = "thingidp"
    val IoTCoreId = "aytczmu"
    val device_key = "MQTT_Device"
    val timestamp = Date().time / 1000
    val algorithm_type = "MD5"
    val device_secret = "cHCLmiTnOVkRtORL"
    return listOf(
        "$adp_type@$IoTCoreId|$device_key|$timestamp|$algorithm_type",
        encode("$device_key&$timestamp&$algorithm_type$device_secret")
    )
}

fun encode(text: String): String {
    try {
        //获取md5加密对象
        val instance: MessageDigest = MessageDigest.getInstance("MD5")
        //对字符串加密，返回字节数组
        val digest:ByteArray = instance.digest(text.toByteArray())
        var sb : StringBuffer = StringBuffer()
        for (b in digest) {
            //获取低八位有效值
            var i :Int = b.toInt() and 0xff
            //将整数转化为16进制
            var hexString = Integer.toHexString(i)
            if (hexString.length < 2) {
                //如果是一位的话，补0
                hexString = "0" + hexString
            }
            sb.append(hexString)
        }
        return sb.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}