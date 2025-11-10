package models.values;

import models.types.IntType;
import models.types.Type;

public class IntValue implements Value{
    private final int val;

    public IntValue(int v) {
        this.val = v;
    }

    public int getValue(){
        return val;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public Value deepCopy() {
        return new IntValue(val);
    }

    @Override
    public String toString(){
        return Integer.toString(val);
    }
}
