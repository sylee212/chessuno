package chessuno;

public interface EntityClicked {
    public ClickType getClickType();

    public void setClickType(ClickType clickType);

    // this is a function that allows you to get the original entity without type casting
    public EntityClicked getOriginal();
}
