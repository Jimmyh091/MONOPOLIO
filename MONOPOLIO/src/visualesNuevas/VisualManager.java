package visualesNuevas;

public class VisualManager {

    private SceneImplementer si;
    private SceneManager sc;

    public VisualManager(SceneImplementer si, SceneManager sc) {

        this.si = si;
        this.sc = sc;

    }

    public void addTest(){
        si.addTest(); //?
    }

}
