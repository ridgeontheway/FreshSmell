package org.wasps.service.smells.concretes;

public abstract class SmellerBase {
    private int id;
    public SmellerBase(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
