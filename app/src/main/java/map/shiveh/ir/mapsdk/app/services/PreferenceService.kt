package map.shiveh.ir.mapsdk.app.services

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by A.Biswas on 8/27/2017.
 */

class PreferenceService(context: Context) {

    var userId: String
        get() = sharedPreferences!!.getString(KEY_USERID, "")
        set(userId) {
            val editor = sharedPreferences!!.edit()
            editor.putString(KEY_USERID, userId)
            editor.commit()
        }

    var userLang: String
        get() = sharedPreferences!!.getString(KEY_USERLANG, "")
        set(lang) {
            val editor = sharedPreferences!!.edit()
            editor.putString(KEY_USERLANG, lang)
            editor.commit()
        }


    var userName: String
        get() = sharedPreferences!!.getString(KEY_USERNAME, "")
        set(userName) {
            val editor = sharedPreferences!!.edit()
            editor.putString(KEY_USERNAME, userName)
            editor.commit()
        }

    var token: String
        get() = sharedPreferences!!.getString(KEY_TOKEN, "")
        set(token) {
            val editor = sharedPreferences!!.edit()
            editor.putString(KEY_TOKEN, token)
            editor.commit()
        }

    init {
        if (sharedPreferences == null) {
            sharedPreferences = context.applicationContext.getSharedPreferences(KEY_PRRFERENCE_NAME, Context.MODE_PRIVATE)
        }
    }


    fun clearUserInfo() {
        val editor = sharedPreferences!!.edit()
        editor.remove(KEY_USERID)
        editor.remove(KEY_USERNAME)
        editor.remove(KEY_USERLANG)
        editor.remove(KEY_TOKEN)
        editor.commit()
    }

    fun clearUserId() {
        val editor = sharedPreferences!!.edit()
        editor.remove(KEY_USERID)
        editor.commit()
    }

    fun clearUserLang() {
        val editor = sharedPreferences!!.edit()
        editor.remove(KEY_USERLANG)
        editor.commit()
    }


    fun clearPreferences() {
        sharedPreferences!!.edit().clear().commit()
    }

    fun clearUserName() {
        val editor = sharedPreferences!!.edit()
        editor.remove(KEY_USERNAME)
        editor.commit()
    }


    fun clearToken() {
        val editor = sharedPreferences!!.edit()
        editor.remove(KEY_TOKEN)
        editor.commit()
    }

    companion object {
        private val KEY_USERNAME = "USER_NAME"
        private val KEY_USERID = "USER_ID"
        private val KEY_USERLANG = "USER_LANG"
        private val KEY_TOKEN = "TOKEN"
        private val KEY_PRRFERENCE_NAME = "map.shiveh.ir.mapsdk"

        private var sharedPreferences: SharedPreferences? = null
        private var preference: PreferenceService? = null

        fun getInstance(context: Context): PreferenceService {
            if (preference == null) {
                preference = PreferenceService(context)
            }
            return preference as PreferenceService
        }
    }

}
