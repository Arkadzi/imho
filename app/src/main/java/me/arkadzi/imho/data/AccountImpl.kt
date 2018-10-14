package me.arkadzi.imho.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import me.arkadzi.imho.data.AccountImpl.Companion.PREF_USER
import me.arkadzi.imho.domain.model.Account
import me.arkadzi.imho.domain.model.User

@SuppressLint("ApplySharedPref")
class AccountImpl(val context: Context) : Account {
    private val preferences
        get() = PreferenceManager.getDefaultSharedPreferences(context)

    override fun saveUser(user: User) {
        preferences.edit()
                .putUser(user)
                .commit()
    }

    override fun saveToken(token: String) {
        preferences.edit()
                .putString(PREF_TOKEN, token)
                .commit()
    }

    override fun getUser(): User? {
        return preferences.getUser()
    }

    override fun getToken(): String? {
        return preferences.getString(PREF_TOKEN, null)
    }

    override fun isAuthorized(): Boolean {
        return getToken() != null
    }

    override fun clear() {
        preferences.edit()
                .clear()
                .commit()
    }

    companion object {
        val PREF_USER = "pref_user"
        val PREF_TOKEN = "pref_token"
    }

}

private fun SharedPreferences.getUser(): User {
    return Gson().fromJson<User>(getString(PREF_USER, null), User::class.java)
}

private fun SharedPreferences.Editor.putUser(user: User): SharedPreferences.Editor {
    putString(PREF_USER, Gson().toJson(user))
    return this
}
