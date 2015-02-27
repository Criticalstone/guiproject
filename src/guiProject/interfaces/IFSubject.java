package guiProject.interfaces;


/**
 * Created by kritt on 2015-02-27.
 */
public interface IFSubject {
    //methods to register and unregister observers
    public void addObserver(IFObserver obj);
    public void removeObserver(IFObserver obj);

    //method to notify observers of change
    public void notifyObserver(Object... obj);

    //method to get updates from listCell
    public Object getUpdate(IFObserver obj);
}
