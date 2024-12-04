package visualesNuevas;

public enum Scenes {
    A(SceneState.ROLL_DICE),
    B(SceneState.ROLL_DICE),
    C(SceneState.ROLL_DICE);

    SceneState[] sceneState;

    private Scenes(SceneState... s) {
        sceneState = s;
    }
}
