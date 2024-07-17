package com.aurora.droid.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.os.Bundle;
import com.android.settings.R;

import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;
import android.provider.Settings;

import com.android.settings.SettingsPreferenceFragment;

public class NotificationSettings extends SettingsPreferenceFragment {

    private static final String KEY_QS_SHOW_AUTO_BRIGHTNESS = "qs_show_auto_brightness";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.aurora_quicksettings);

	PreferenceScreen preferenceScreen = getPreferenceScreen();
        Preference qsShowAutoBrightnessPreference = preferenceScreen.findPreference(KEY_QS_SHOW_AUTO_BRIGHTNESS);

        if (qsShowAutoBrightnessPreference != null) {
            boolean automaticBrightnessAvailable = getContext().getResources().getBoolean(
                    com.android.internal.R.bool.config_automatic_brightness_available);
            if (!automaticBrightnessAvailable) {
                qsShowAutoBrightnessPreference.setVisible(false);
            }
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.AURORA_DROID;
    }
}
