package map.shiveh.ir.mapsdk.features.network.base;

public interface Callable<T> {
    T call(SessionManager sessionManager) throws Exception;
}
