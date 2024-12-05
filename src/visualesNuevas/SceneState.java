package visualesNuevas;

public enum SceneState {

    //
    START_GAME(true, true),

    // GAME SCENES //
    ROLL_DICE(true, true, true, true, false, false, false, true, true, true, true, true, false),
    BUY_PROPERTY(),
    PAY_DEBT(),
    INTERACT_SPECIAL_SQUARE(),
    DRAW_CARD(),
    INTERACT(),
    DEAL();

    boolean[] elements;

    private SceneState(boolean... elements){
        this.elements = elements;
    }

    public boolean[] getElements() {
        return elements;
    }

    public boolean getElement(int i){
        return elements[i];
    }
}
