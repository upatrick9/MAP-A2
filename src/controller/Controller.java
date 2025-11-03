package controller;

import models.PrgState;
import models.adts.MyIStack;
import models.adts.MyStack;
import models.exceptions.*;
import models.statements.IStmt;
import repository.IRepository;

public class Controller implements IController{
    private final IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    @Override
    public PrgState oneStep(PrgState state) throws MyException{
        MyIStack<IStmt> stack = state.getExeStack();
        if(stack.isEmpty()){
            throw new MyException("Stack is empty");
        }
        IStmt stmt = stack.pop();
        return stmt.execute(state);
    }

    @Override
    public void allStep() throws MyException{
        PrgState prg = repo.getCurrentProgram();
        while(!prg.getExeStack().isEmpty()){
            oneStep(prg);
            System.out.println(prg);
        }
    }

}
