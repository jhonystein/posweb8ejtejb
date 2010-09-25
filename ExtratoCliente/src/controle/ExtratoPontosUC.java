/**
 * ExtratoPontosUC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package controle;

public interface ExtratoPontosUC extends java.rmi.Remote {
    public int login(java.lang.String cpf, java.lang.String senha) throws java.rmi.RemoteException, controle.Exception;
    public void logout(int codigoCliente) throws java.rmi.RemoteException, controle.Exception;
    public controle.Movimentacao[] extratoPontos(int codigoCliente) throws java.rmi.RemoteException, controle.Exception;
    public void gastarPontos(int codigoCliente, int codigoProduto) throws java.rmi.RemoteException;
    public void descontarPontosMes() throws java.rmi.RemoteException;
}
