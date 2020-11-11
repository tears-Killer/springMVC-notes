package com.chinasoft.domain;

import java.util.List;

public class UserList {
    private List<User> ulist;

    public List<User> getUlist() {
        return ulist;
    }

    public void setUlist(List<User> ulist) {
        this.ulist = ulist;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "ulist=" + ulist +
                '}';
    }
}
