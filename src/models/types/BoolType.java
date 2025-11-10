package models.types;

public class BoolType implements Type{
    @Override
    public boolean equals(Object another) {
        return another instanceof BoolType;
    }

    @Override
    public Type deepCopy() {
        return new BoolType();
    }

    @Override
    public String toString() {
        return "bool";
    }
}
