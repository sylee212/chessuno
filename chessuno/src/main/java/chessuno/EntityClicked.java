package chessuno;

/**
 * NEED TO STUDY MORE
 * This pattern is known as a recursive type bound or a self-referential generic type. 
 * 
 * EntityClicked<T extends EntityClicked<T>>
 * T -> will act as a variable which can be replaced by any class that implmenets it, T can be any variable but must be consistent 
 * T extends EntityClicked<T> -> T must be a subtype of EntityClicked<T>. this makes sure that T must implement EntityClicked interface
 * 
 * public interface EntityClicked< T extends EntityClicked<T>>
 */
public interface EntityClicked {
    public ClickType getClickType();

    public void setClickType(ClickType clickType);

    // this is a function that allows you to get the original entity without type casting
    public EntityClicked getOriginal();
}
