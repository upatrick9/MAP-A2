package models.types;

public interface Type {
    boolean equals(Object another);
    String toString();
    Type deepCopy();
}
