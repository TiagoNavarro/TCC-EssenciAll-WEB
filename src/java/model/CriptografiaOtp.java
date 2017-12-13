package model;

import java.util.Random;

public class CriptografiaOtp {

    public String criptografa(String mensagem, String chave) {
                  if (mensagem.length() != chave.length()) error("O tamanho da mensagem e da chave devem ser iguais.");
                  int[] im = charArrayToInt(mensagem.toCharArray());
                  int[] ik = charArrayToInt(chave.toCharArray());
                  int[] data = new int[mensagem.length()];
                 
                  for (int i=0;i<mensagem.length();i++) {
                          data[i] = im[i] + ik[i];
                  }
                 
                  return new String(intArrayToChar(data));
          }
         
          public String decriptografa(String mensagem, String chave) {
                  if (mensagem.length() != chave.length()) error("O tamanho da mensagem e da chave devem ser iguais.");
                  int[] im = charArrayToInt(mensagem.toCharArray());
                  int[] ik = charArrayToInt(chave.toCharArray());
                  int[] data = new int[mensagem.length()];
                 
                  for (int i=0;i<mensagem.length();i++) {
                          data[i] = im[i] - ik[i];
                  }
                 
                  return new String(intArrayToChar(data));
          }
         
          public String genKey(int tamanho) {
                  Random randomico = new Random();
                  char[] key = new char[tamanho];
                  for (int i=0;i<tamanho;i++) {
                          key[i] = (char) randomico.nextInt(132);
                          if ((int) key[i] < 97) key[i] = (char) (key[i] + 72);
                          if ((int) key[i] > 122) key[i] = (char) (key[i] - 72);
                  }
                 
                  return new String(key);
          }
          
          public String genCodigo(){
              Random random = new Random();
              char[] codigo = new char[10];
              for (int i = 0; i < 10; i++) {
                  codigo[i] = (char) random.nextInt(132);
                  if ((int) codigo[i] < 97) codigo[i] = (char) (codigo[i] + 72);
                  if ((int) codigo[i] > 122) codigo[i] = (char) (codigo[i] - 72);
              }
              return new String(codigo);
          }
         
          private int chartoInt(char c) {
                  return (int) c;
                  
          }
         
          private char intToChar(int i) {
                  return (char) i;
          }
         
          private int[] charArrayToInt(char[] cc) {
                  int[] ii = new int[cc.length];
                  for(int i=0;i<cc.length;i++){
                          ii[i] = chartoInt(cc[i]);
                  }
                  return ii;
          }
         
          private char[] intArrayToChar(int[] ii) {
                  char[] cc = new char[ii.length];
                  for(int i=0;i<ii.length;i++){
                          cc[i] = intToChar(ii[i]);
                  }
                  return cc;
          }
         
          private void error(String msg) {
                  System.out.println(msg);
                  System.exit(-1);
          }
    
}
