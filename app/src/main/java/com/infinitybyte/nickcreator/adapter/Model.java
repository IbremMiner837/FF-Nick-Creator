package com.infinitybyte.nickcreator.adapter;

public class Model {

    String nickname;

    public Model() {
        //
    }

    public Model(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
