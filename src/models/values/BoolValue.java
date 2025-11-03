package models.values;

import models.types.BoolType;
import models.values.BoolValue;
import models.types.Type;

public class BoolValue implements Value {
    private final boolean val;

    public BoolValue(boolean v) {
        this.val = v;
    }

    public boolean getValue() {
        return val;
    }

    @Override
    public String toString() {
        return Boolean.toString(val);
    }

    @Override
    public Type getType() {
        return new BoolType();
    }
}
