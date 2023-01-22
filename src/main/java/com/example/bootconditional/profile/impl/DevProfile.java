package com.example.bootconditional.profile.impl;

import com.example.bootconditional.profile.SystemProfile;

public class DevProfile implements SystemProfile {

    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
