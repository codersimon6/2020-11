package User;

import operation.IOperation;

public abstract class User {
    protected String name;

    protected IOperation[] doOperation;
    public User(String name) {
        this.name = name;
    }

    public IOperation doOperation(int choice) {
        return doOperation[choice];
    };
    public abstract int menu();


}
