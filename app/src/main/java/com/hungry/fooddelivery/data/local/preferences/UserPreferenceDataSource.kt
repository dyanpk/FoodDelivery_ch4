package com.hungry.fooddelivery.data.local.preferences

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.hungry.fooddelivery.presentation.feature.home.adapter.subadapter.AdapterLayoutMode
import com.hungry.fooddelivery.utils.PreferenceDataStoreHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface UserPreferenceDataSource {
    suspend fun getUserLayoutPref(): AdapterLayoutMode
    fun getUserLayoutPrefFlow(): AdapterLayoutMode
    suspend fun setUserLayoutPref(layoutType: AdapterLayoutMode)
}

class UserPreferenceDataSourceImpl(
    private val preferenceHelper: PreferenceDataStoreHelper
) : UserPreferenceDataSource {



    override suspend fun getUserLayoutPref(): AdapterLayoutMode {
        val layoutType = preferenceHelper.getFirstPreference(PREF_USER_LAYOUT, AdapterLayoutMode.GRID.name)
        return AdapterLayoutMode.valueOf(layoutType)
    }

    override fun getUserLayoutPrefFlow(): AdapterLayoutMode {
        val layoutType = preferenceHelper.getPreference(PREF_USER_LAYOUT, AdapterLayoutMode.GRID.name)
        return AdapterLayoutMode.valueOf(layoutType.toString())
    }

    override suspend fun setUserLayoutPref(layoutType: AdapterLayoutMode) {
        preferenceHelper.putPreference(PREF_USER_LAYOUT, layoutType.name)
    }

    companion object {
        val PREF_USER_LAYOUT = stringPreferencesKey("PREF_USER_LAYOUT")
    }
}
