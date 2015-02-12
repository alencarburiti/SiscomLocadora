/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

//import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Alencar
 */
public class Data {

    public String mes, dia, ano, dia_semana, hora;
    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm:ss");

    public void le_hora() {
        Date horaAtual = new Date();
        hora = horaformatada.format(horaAtual);
    }

    public void le_data() {
        Date data = new Date();
        mes = "" + data.getMonth();//0 a 11;
        dia = "" + data.getDate();
        ano = "" + (1900 + data.getYear());
        dia_semana = "" + data.getDay();
        /*
         switch(data.getMonth()){
         case 0: mes = "Janeiro";break;
         case 1: mes = "Fevereiro";break;
         case 2: mes = "Março";break;
         case 3: mes = "Abril";break;
         case 4: mes = "Maio";break;
         case 5: mes = "Junho";break;
         case 6: mes = "Julho";break;
         case 7: mes = "Agosto";break;
         case 8: mes = "Setembro";break;
         case 9: mes = "Outubro";break;
         case 10: mes = "Novembro";break;
         case 11: mes = "Dezembro";break;
        
         }

         */
    }

    public int calcularIdade(Date dataNascimento) {
        //Calcula a Idade baseado em java.util.Date   
        Calendar dateOfBirth = new GregorianCalendar();

        dateOfBirth.setTime(dataNascimento);

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, age);

        //se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (today.before(dateOfBirth)) {

            age--;

        }

        return age;

    }

}
