package map.shiveh.ir.mapsdk.app.base;


public abstract class Presenter implements IPresenter {

    protected AppView mView = null;


    public Presenter(AppView view) {
        this.mView = view;
    }


}
