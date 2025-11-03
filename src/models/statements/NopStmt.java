package models.statements;

import models.PrgState;
import models.exceptions.MyException;

public class NopStmt implements IStmt{
    @Override
    public PrgState execute(PrgState state) throws MyException {
        return state;
    }

    @Override
    public String toString(){
        return "nop";
    }
}
