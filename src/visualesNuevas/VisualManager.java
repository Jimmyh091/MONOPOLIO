package visualesNuevas;

import juego.GameManager;

public class VisualManager {

    SceneManager sm;
    SceneImplementer si;
    GameManager gm;

    public VisualManager(SceneManager sm) {
        this.sm = sm;
        GameManager gm = new GameManager(null); //t
        si = new SceneImplementer(gm);
        addTestSquaresPos();
    }

    public void addTest(){
        sm.addScene("test", si.addTest(sm));
    }

    public void addTitleScene(){
        sm.addScene("title", si.addTest(sm));
    }

    public void addGameScene(){
        sm.addScene("game", si.addGameScene(sm));
    }

    public void addTestSquaresPos(){
        sm.addScene("testSqrPos", si.addTestSquaresPos(sm));
    }
}
