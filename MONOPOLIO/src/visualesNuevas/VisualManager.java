package visualesNuevas;

import juego.GameManager;

public class VisualManager {

    SceneManager sm;
    SceneImplementer si;

    public VisualManager(SceneManager sm, GameManager gm) {
        this.sm = sm;
        si = new SceneImplementer(gm);
        addGameScene();
    }

    public void addTest(){
        sm.addScene("test", si.addTest(sm));
    }

    public void addTitleScene(){
        sm.addScene("test", si.addTest(sm));
    }

    public void addGameScene(){
        sm.addScene("game", si.addGameScene(sm));
    }
}
