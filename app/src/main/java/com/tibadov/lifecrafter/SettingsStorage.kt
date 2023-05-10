package com.tibadov.lifecrafter

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

enum class SettingKeys(val key: String) {
    STARTING_VALUE("starting_value"),
    NUMBER_OF_PLAYERS("number_of_players")
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStorage(private val context: Context) {

    fun getValue(key: SettingKeys): Int? {
        return runBlocking {
            val data = context.dataStore.data.first()
            val dataStoreKey = intPreferencesKey(key.key)
            data[dataStoreKey]
        }
    }

    fun setValue(key: SettingKeys, value: Int) {
        GlobalScope.launch {
            context.dataStore.edit { settings ->
                val dataStoreKey = intPreferencesKey(key.key)
                settings[dataStoreKey] = value
            }
        }
    }
}

