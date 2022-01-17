/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author asus X556U
 */
public class EVA3_1_BUSQUEDA_BINARIA {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      int[] datos = new int[20];
      llenar(datos);//Envío el arreglo a llenar con valores aleatorios
      imprimir(datos);
      selectionSort(datos);
      imprimir(datos);
      Scanner input = new Scanner(System.in);
      System.out.println("\nValor a buscar: ");
      int valor = input.nextInt();
      int iResu = binarySearch(datos, valor);
      System.out.println("El elemento está en la posición: " + iResu);
   }
   
   //LLENADO DEL ARREGLO CON VALORES ALEATORIOS 0 - 99
   public static void llenar (int[] datos){
      for (int i = 0; i < datos.length; i++){
         datos[i] = (int)(Math.random() * 100);
      }
   }
   
   //DUPLICAR ARREGLO (arreglos del mismo tamaño)
   public static void duplicar(int[] datos, int[] copia){
      for (int i = 0; i < datos.length; i++){
         datos[i] = (int)(Math.random() * 100);
      }
   }
   //COPIA DEL ARREGLO
   //IMPRIMIR ARREGLO
   public static void imprimir(int[] datos){
      System.out.println("");
      for (int i = 0; i < datos.length; i++) {
         int iMin = i;
         System.out.print("[" + datos[i] + "]");
            
         }
      }
      
   //EFICIENCIA O(N^2)
   public static void selectionSort(int[] datos){
         for (int i = 0; i < datos.length; i++){
            int iMin = i;//EMPIEZA EL ALGORITMO, EL MÍNIMO ES EL PRIMER ELEMENTO
            for (int j = i + 1; j < datos.length; j++){//BUSCAR LA POSICIÓN DEL VALOR MÁS PEQUEÑO
               //COMPARAR
               //Valor[j] vs valor [min]
               if (datos[j] < datos[iMin]){//COMPARO ACTUAL VS EL MÍNIMO ACTUAL
                  iMin = j;
               }
            }
            //INTERCAMBIO
            if (i !=iMin){
               //3 PASOS
               //RESPALDAR UN VALOR
               int iTemp = datos[i];
               //INTERCAMBIAR UN VALOR
               datos[i] = datos[iMin];
               //REPONER EL VALOR RESPALDADO
               datos[iMin] = iTemp;
            }
         }
      }
   
   //LA BUSQUEDA BINARIA ES RECURSIVA
   //O(logN)
   public static int binarySearch(int[] datos, int valBuscar){
      return binarySearchRecu(datos, valBuscar, 0, datos.length - 1);
   }
   
   private static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin){
      int iMid, iResu;
      iMid = ini + ((fin - ini) / 2);//posición a la mitad de la busqueda
      iResu = -1;//SI EL VALOR NO EXISTE, REGRESAMOS -1
      if(fin >= ini){//buscamos
         if(valBuscar == datos[iMid]){//EL VALOR ESTA A LA MITAD
            iResu = iMid;//aquí esta el valor, y lo regresamos
         }else if(valBuscar < datos[iMid]){//NO ESTA A LA MITAD, PERO ESTA A LA IZQ
            //Llamamos recursivamente a la busqueda binaria
            iResu = binarySearchRecu(datos, valBuscar, ini, iMid - 1);
         }else{//NO ESTA, PERO PUEDE ESTAR A LA DER
            iResu = binarySearchRecu(datos, valBuscar, iMid + 1, fin);
            
         }
      }//Se detiene el proceso
      
      return iResu;
   }
 }
      