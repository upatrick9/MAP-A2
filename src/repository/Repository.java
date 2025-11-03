package repository;

import models.PrgState;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private final List<PrgState> prgList = new ArrayList<>();

    public Repository(PrgState prg) {
        prgList.add(prg);
    }

    @Override
    public PrgState getCurrentProgram() {
        return prgList.getFirst();
    }

}
