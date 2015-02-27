package guiProject.interfaces;


/**
 * Created by kritt on 2015-02-27.
 */
public interface IFObserver {

    //method to update the observer, used by subject
    public void update(Object... obj);

    //attach with subject to observe
    public void setSubject(IFSubject sub);
}