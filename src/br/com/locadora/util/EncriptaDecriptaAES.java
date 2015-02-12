package br.com.locadora.util;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
 
/**
 * @author diogo.souza
 */
public class EncriptaDecriptaAES {
 
    public EncriptaDecriptaAES() {
    }
 
    /**
     * Gera uma chave criptografica de 128bits aleatória
     * @return byte[] key
     */
    public byte[] key() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey key = keyGen.generateKey();
        return key.getEncoded();
    }
    
    public Key generateKey(String key){
        byte [] keyArray = toHex(key);        
        return new SecretKeySpec(keyArray, "AES");
    }
 
    /**
     * Encripta uma mensagem usando AES para uma dada chave
     * @param byte[] input deve estar em um tamanho multiplo de 16 (nullPadString)
     * @param byte[] key
     * @return
     */
    public byte[] encode(byte[] input, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
        
        
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(input);
        return encrypted;
    }
 
    /**
     * Retorna o valor original de uma mensagem criptgrafada em AES
     * @param byte[] input
     * @param byte[] key
     * @return
     */
    public byte[] decode(byte[] input, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(input);
        return decrypted;
    }
    
    static String IV = "AAAAAAAAAAAAAAAA";    
    
    public byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }

    public String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception {
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado), "UTF-8");
    }
 
    /**
     * Converte uma mensagem criptografada para uma string de sua representação hexadecimal.
     * @param byte[] hex
     * @return String str
     */
    public String fromHex(byte[] hex) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < hex.length; i++) {
            sb.append( Integer.toString( ( hex[i] & 0xff ) + 0x100, 16).substring( 1 ) );
        }
        return sb.toString();
    }
 
    /**
     * Converte uma representação hexadecimal para seus bytes hexadecimal (valor encriptado)
     * @param String s
     * @return byte[] data
     */
    public byte[] toHex(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
 
    /**
     * Corrige o tamanho de uma String para multiplo de 16
     * @param String original
     * @return String final
     */
    public String nullPadString(String original) {
         StringBuffer output = new StringBuffer(original);
         int remain = output.length() % 16;
         if (remain != 0) {
             remain = 16 - remain;
             for (int i = 0; i < remain; i++)
                 output.append((char) 0);
         }
         return output.toString();
     }
}
 
 