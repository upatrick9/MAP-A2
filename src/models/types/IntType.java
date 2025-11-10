package models.types;

public class IntType implements Type {
    @Override
    public boolean equals(Object another) {
        return another instanceof IntType;
    }

    @Override
    public Type deepCopy() {
        return new IntType();
    }

    @Override
    public String toString() {
        return "int";
    }
}
