/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

/**
 *
 * @author alencarburiti
 */
public class Licenca {

    public void verificarLicenca() {
        LocalHost local = new LocalHost();
        String ip = local.hostAddress();
        String name = local.macAddress();

    }

}
