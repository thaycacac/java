import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author THAYCACAC
 */
public interface Calculator extends Remote{
    double add(double a, double b) throws RemoteException;
    double sub(double a, double b) throws RemoteException;
    double mul(double a, double b) throws RemoteException;
    double div(double a, double b) throws RemoteException;
}
