package com.xalion95.xpackutils.proxy;

import com.xalion95.xpackutils.utility.LogHelper;

public class ServerProxy extends CommonProxy {

    @Override
    public void validateEnv() {
        //NOOP
    }

    @Override
    public void inform() {
        //NOOP
    }

    @Override
    public void informSrv() {
        LogHelper.warn("You are using the old version of modpack! Clients are going to inform users...");
    }
}
