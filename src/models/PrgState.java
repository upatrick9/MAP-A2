package models;

import models.adts.*;
import models.statements.IStmt;
import models.values.Value;

public class PrgState {
    private final MyIStack<IStmt> exeStack;
    private final MyIDictionary<String, Value> symTable;
    private final MyIList<Value> out;
    private final IStmt originalProgram;

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symTable, MyIList<Value> out, IStmt originalProgram) {
        this.exeStack = stk;
        this.symTable = symTable;
        this.out = out;
        this.originalProgram = originalProgram.deepCopy();
        exeStack.push(originalProgram);
    }

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    @Override
    public String toString() {
        return "Stack: " + exeStack + "\nSymTable: " + symTable + "\nOut: " + out + "\n";
    }
}
