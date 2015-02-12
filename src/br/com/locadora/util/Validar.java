/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.util;

/*
 * Classe responsável por efetuar as validações de campos do sistema.
 */


public class Validar {

    /*
     * Método que faz a Validação de CPF
     * @return true se valido, false se invalido
     */
    public static boolean vCPF(String var){
        boolean teste = false;
        int var2[] = removeCaracter(var);
        int soma1=0,soma2=0,dig1,dig2,ver=11;
        for(int i=0; i<9; i++){
            soma2 += var2[i]*(ver--);
            soma1 += var2[i]*(ver);
        }
        dig1 = soma1%11 < 2 ? 0 : 11-soma1%11;
        soma2 += var2[9]*(ver--);
        dig2 = soma2%11 < 2 ? 0 : 11-soma2%11;
        if(dig1==var2[9] & dig2==var2[10]){
            teste = true;
        }
        return teste;
    }

    /*
     * Método que faz a Validação de CNPJ
     * @return true se valido, false se invalido
     */
    public static boolean vCNPJ(String var){
        boolean teste = false;
        int var2[] = removeCaracter(var);
        int varTest[] = {2,3,4,5,6,7,8,9,2,3,4,5,6};
        int soma1=0,soma2=0,dig1,dig2,ver=12;
        for(int i=0; i<12; i++){
            soma2 += var2[i]*varTest[ver--];
            soma1 += var2[i]*varTest[ver];
        }
        dig1 = soma1%11 < 2 ? 0 : 11-soma1%11;
        soma2 += var2[12]*varTest[ver--];
        dig2 = soma2%11 < 2 ? 0 : 11-soma2%11;
        if(dig1==var2[12] & dig2==var2[13]){
            teste = true;
        }
        return teste;
    }

    /*
     * Método que remove Caracters especiais de mascara de um String e converte para inteiro
     * @return int[]
     */
    public static int[] removeCaracter(String var){
        int var2[] = new int[var.length()];
        int cont=0;
        for(int i=0; i<var.length(); i++){
            char ch = var.charAt(i);
            if(!(ch=='.' || ch=='-' || ch=='/' || ch=='(' || ch==')' || ch==' ')){
                var2[cont++] = (Integer.parseInt(""+var.charAt(i)));
            }
        }
        return var2;
    }

    /*
     * Método que remove Caracters especiais de mascara de um String
     * @return String
     */
    public static String removeCaracter2(String var){
        var = var.replace(".", "");
        var = var.replace("-", "");
        var = var.replace("/", "");
        var = var.replace("(", "");
        var = var.replace(")", "");
        var = var.replace(" ", "");
        return var.trim();
    }
}