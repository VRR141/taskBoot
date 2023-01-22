package com.example.bootconditional.profile.impl;

import com.example.bootconditional.profile.SystemProfile;

public class ProductionProfile implements SystemProfile {

    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
