package interfaz;

public class Presenter implements MyInterface{

    @Override
    public void mostrarLoginCorrecto() {
        System.out.println("Login Correcto");
    }

    @Override
    public void mostrarLoginIncorrecto() {
        System.out.println("Login Incorrecto");
    }
}
