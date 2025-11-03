package view;

import controller.Controller;
import models.*;
import models.adts.*;
import models.expressions.*;
import models.statements.*;
import models.types.*;
import models.values.*;
import repository.IRepository;
import repository.Repository;

import java.util.Scanner;

public class View {
    private IStmt buildExample1() {
        return new CompStmt(
                new VarDeclStmt("v", new IntType()),
                new CompStmt(
                        new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))
                )
        );
    }

    private IStmt buildExample2() {
        return new CompStmt(
                new VarDeclStmt("a", new IntType()),
                new CompStmt(
                        new VarDeclStmt("b", new IntType()),
                        new CompStmt(
                                new AssignStmt("a",
                                        new ArithExp('+',
                                                new ValueExp(new IntValue(2)),
                                                new ArithExp('*',
                                                        new ValueExp(new IntValue(3)),
                                                        new ValueExp(new IntValue(5)))
                                        )
                                ),
                                new CompStmt(
                                        new AssignStmt("b",
                                                new ArithExp('+',
                                                        new VarExp("a"),
                                                        new ValueExp(new IntValue(1)))
                                        ),
                                        new PrintStmt(new VarExp("b"))
                                )
                        )
                )
        );
    }

    private IStmt buildExample3() {
        return new CompStmt(
                new VarDeclStmt("a", new BoolType()),
                new CompStmt(
                        new VarDeclStmt("v", new IntType()),
                        new CompStmt(
                                new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("a"),
                                                new AssignStmt("v", new ValueExp(new IntValue(2))),
                                                new AssignStmt("v", new ValueExp(new IntValue(3)))
                                        ),
                                        new PrintStmt(new VarExp("v"))
                                )
                        )
                )
        );
    }

    private void runExample(IStmt example) {
        MyIStack<IStmt> stk = new MyStack<>();
        MyIDictionary<String, Value> symtbl = new MyDictionary<>();
        MyIList<Value> out = new MyList<>();

        PrgState prg = new PrgState(stk, symtbl, out, example);
        IRepository repo = new Repository(prg);
        Controller ctrl = new Controller(repo);

        try{
            ctrl.allStep();
            System.out.println("Program finished successfully");
            System.out.println("Final Output: " + prg.getOut().toString());
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void start(){
        IStmt ex1 = buildExample1();
        IStmt ex2 = buildExample2();
        IStmt ex3 = buildExample3();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("1.Run example 1");
            System.out.println("2.Run example 2");
            System.out.println("3.Run example 3");
            System.out.println("0.Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice){
                case "1" -> runExample(ex1);
                case "2" -> runExample(ex2);
                case "3" -> runExample(ex3);
                case "0" -> running = false;
                default -> System.out.println("Invalid choice");
            }

        }
    }
}
