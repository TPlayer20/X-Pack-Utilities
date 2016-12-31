package com.xalion95.xpackutils.reference;

public class Paczka {
    private String name;
    private int version;
    private String url_moc;
    private String url_cms;
    private String url_optifine;
    private String updateMessage;
    private boolean hasNewerVersion;
    private String profile;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUrl_moc() {
        return url_moc;
    }

    public void setUrl_moc(String url_moc) {
        this.url_moc = url_moc;
    }

    public String getUrl_cms() {
        return url_cms;
    }

    public void setUrl_cms(String url_cms) {
        this.url_cms = url_cms;
    }

    public String getUrl_optifine() {
        return url_optifine;
    }

    public void setUrl_optifine(String url_optifine) {
        this.url_optifine = url_optifine;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String upadteMessage) {
        this.updateMessage = upadteMessage;
    }

    public boolean isHasNewerVersion() {
        return hasNewerVersion;
    }

    public void setHasNewerVersion(boolean hasNewerVersion) {
        this.hasNewerVersion = hasNewerVersion;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
