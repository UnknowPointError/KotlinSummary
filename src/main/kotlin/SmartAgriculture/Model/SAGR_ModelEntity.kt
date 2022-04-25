package MineBBS.Model

import com.google.gson.annotations.SerializedName

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/4/12 21:06 周二 下午
@Description: MineBBS模型数据
*/

object SAGR_ModelEntity {
    object GET {

    }

    object POST {
        data class TokenEntity(
            @SerializedName("token")
            val token : String
        )
        /*
            /* 上文中组合得到的用户名 */
            @SerializedName("username")
            val UserName : String?,

            /* 上文中计算得到的密码 */
            @SerializedName("password")
            val PassWord : String?,

            /* 当前只支持application/json */
            @SerializedName("Accept")
            val Accept: String?,

            /* token有效时长，默认600秒 */
            @SerializedName("tokenLifeSpanlnSeconds")
            val tokenAliveTime: Int?*/
    }

    object JsonEntity {
        data class User(
            @SerializedName("username")
            val userName: String,

            @SerializedName("password")
            val passWord: String
        )
    }
}