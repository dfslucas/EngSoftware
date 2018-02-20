/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author eldi
 */
public class Reserva {
    String clienteCPF, carPLACA;
    public Reserva() {
    }

    public Reserva(String clienteCPF, String carPLACA) {
        this.clienteCPF = clienteCPF;
        this.carPLACA = carPLACA;
    }

    public String getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(String clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public String getCarPLACA() {
        return carPLACA;
    }

    public void setCarPLACA(String carPLACA) {
        this.carPLACA = carPLACA;
    }
    
}
