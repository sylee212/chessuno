package chessuno;

public interface EntityClicked {
    public ClickType getClickType();

    public void setClickType(ClickType clickType);

    public void entityClicked();

    public Color getEntityChessPieceColor();
}
