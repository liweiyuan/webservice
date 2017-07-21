/**
 * IService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IService extends java.rmi.Remote {
    public void openSql() throws java.rmi.RemoteException;
    public void closeSql() throws java.rmi.RemoteException;
    public org.tempuri.QuerySqlResponseQuerySqlResult querySql() throws java.rmi.RemoteException;
}
