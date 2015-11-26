package ottotool;

import com.squareup.otto.*;

import java.util.Objects;

/**
 * Created by shirley on 15/11/26.
 */
public class OttoTool {
    static public OttoTool __ottoTool = null;

    private Bus __bus;

    public static OttoTool share() {

        if (__ottoTool == null) {

            __ottoTool = new OttoTool();
        }
        return __ottoTool;
    }

    OttoTool() {

        __bus = new Bus(ThreadEnforcer.MAIN);
    }

    // register
    public void register(Object object) {

        __bus.register(object);
    }

    // unregister
    public void unregister(Object object) {

        __bus.unregister(object);
    }

    // post event
    public void postOttoEvent(OttoEvent ottoEvent) {

        __bus.post(ottoEvent);
    }
}
