package chessuno.actions;


public abstract class ActionAbstract {

    public ActionAbstract() {}

    public abstract boolean execute();

    public abstract boolean verify();

    public abstract void fillInformation(ActionInformation actionInformation);

}
