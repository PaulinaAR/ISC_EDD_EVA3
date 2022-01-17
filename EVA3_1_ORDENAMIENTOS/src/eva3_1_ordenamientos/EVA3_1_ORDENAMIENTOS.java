/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamientos;

/**
 *
 * @author asus X556U
 */
public class EVA3_1_ORDENAMIENTOS {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      //VAMOS A ORDENAR ARREGLOS (INT)
      int[] datos = new int[20];
      int[] copiaSel = new int [datos.length];
      int[] copiaIns = new int [datos.length];
      int[] copiaBubble = new int [datos.length];
      int[] copiaQuickSort = new int [datos.length];
      long iniT, finT; 
      llenar(datos);//ENVÍO EL ARREGLO A LLENAR CON VALORES ALEATORIOS
      
      System.out.println("PRUEBA CON SELECTION SORT: ");
      duplicar(datos, copiaSel);
      imprimir(copiaSel);
      iniT = System.nanoTime();//TIEMPO ANTES DE EMPEZAR EL MÉTODO
      //ORDENAMOS
      selectionSort(copiaSel);
      finT = System.nanoTime();//TIEMPO AL TERMINAR EL MÉTODO
      imprimir(copiaSel);
      System.out.println("\nTiempo en ordenar: " + (finT - iniT));
      
      System.out.println("\nPRUEBA CON INSERTION SORT: ");
      duplicar(datos, copiaIns);
      imprimir(copiaIns);
      iniT = System.nanoTime();//TIEMPO ANTES DE EMPEZAR EL MÉTODO
      //ORDENAMOS
      insertionSort(copiaIns);
      finT = System.nanoTime();//TIEMPO AL TERMINAR EL MÉTODO
      imprimir(copiaIns);
      System.out.println("\nTiempo en ordenar: " + (finT - iniT));
      
      System.out.println("\nPRUEBA CON BUBBLESORT: ");
      duplicar(datos,copiaBubble);
      imprimir(copiaBubble);
      iniT = System.nanoTime();//TIEMPO ANTES DE EMPEZAR EL MÉTODO
      //ORDENAMOS
      bubbleSort(copiaBubble);
      finT = System.nanoTime();//TIEMPO AL TERMINAR EL MÉTODO
      imprimir(copiaBubble);
      System.out.println("\nTiempo en ordenar: " + (finT - iniT));
      
      System.out.println("\nPRUEBA CON QUICKSORT:");
      duplicar(datos, copiaQuickSort);
      imprimir(copiaQuickSort);
      iniT = System.nanoTime();//TIEMPO ANTES DE EMPEZAR EL MÉTODO
      //ORDENAMOS
      quickSort(copiaQuickSort);
      finT = System.nanoTime();//TIEMPO AL TERMINAR El MÉTODO
      imprimir(copiaQuickSort);
      System.out.println("\nTiempo en ordenar: " + (finT - iniT));
  }
   //LLENADO DE ARREGLO CON VALORES ALEATORIOS 0 - 99
   public static void llenar(int[] datos){
      for (int i = 0; i < datos.length; i++){
         datos[i] = (int) (Math.random() * 100);
      }
   }
   
   //DUPLICAR ARREGLO (ARREGLOS DEL MISMO TAMAÑO)
   public static void duplicar(int[] datos, int[] copia){
      for (int i = 0; i < datos.length; i++){
         copia[i] = datos[i];
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
   public static void insertionSort(int[] datos){
      for (int i = 1; i < datos.length; i++){
         int temp = datos[i];//Valor a insertar
         int insP = i;//Posición donde vamos a insertar
         for (int prev = i - 1; prev >= 0; prev--){//Buscar donde insertar
            if(datos[prev] > temp){
               datos[insP] = datos[prev];//movemos el valor de prev a la posición de insP
               insP--; //retrocede una posición
            }else{
               break;
            }
          }
         //INSERTAMOS
         datos[insP] = temp;
        }
      }
   
   //EFICIENCIA O(N^2)
   public static void bubbleSort(int[] datos){
      for(int i = 0; i < datos.length; i++){//PASADAS
         for(int j = 0; j < (datos.length - 1); j++){//COMPARA E INTERCAMBIA
            if(datos[j] > datos[j + 1]){//comparamos j vs j + 1
               //INTERCAMBIAMOS
               int temp = datos[j];
               datos[j] = datos[j + 1];
               datos[j + 1] = temp;
            }
         }
      }
   }
   //QUICKSORT DE ARRANQUE
   //O(NlogN) Logarítmo base 2
   public static void quickSort(int[] datos){
      quickSortRecu(datos, 0 , datos.length - 1);//Quicksort a todo el arreglo
   }
   
   private static void quickSortRecu(int[] datos, int ini, int fin){
      int iPivote;//inicio
      int too_big;//busca a lo más grandes que el pivote
      int too_small;//busca a los más pequeños del pivote
      boolean stopBig = false, stopSmall = false;
      
      //CONTROLAR LA RECURSIVIDAD:
      int tama = fin - ini + 1;
      if(tama > 1){//¿Cuando SI puedo realizar un quicksort?
         iPivote = ini;
         too_big = ini + 1;
         too_small = fin;
         for(int i = ini + 1; i <= fin; i++){//Número de veces a recorrer
            if((datos[too_big] < datos[iPivote]) && (!stopBig)){//AVANZO
               too_big++;//AVANZO
            }else{
               stopBig = true;//Me detengo cuando encuentro uno más grande
            }
            if((datos[too_small] >= datos[iPivote]) && (!stopSmall)){//AVANZO
               too_small--;//RETROCEDO
            }else{
               stopSmall = true;//Me detengo cuando encuentro uno más pequeño
            }
            //ambos se detienen (swap)
            if(stopBig && stopSmall){
               if(too_big < too_small){//INTERCAMBIO SWAP
                  int temp = datos[too_big];
                  datos[too_big] = datos[too_small];
                  datos[too_small] = temp;
                  stopBig = false;//seguir avanzando
                  stopSmall = false;//seguir avanzando
               }else{
                  break;//Termino el ciclo
            }
         }
      }
         //Intercambio el pivote
         int temp = datos[iPivote];
         datos[iPivote] = datos[too_small];
         datos[too_small] = temp;
         iPivote = too_small;//TAMBIÉN CAMBIA LA POSICIÓN DEL PIVOTE
         //quicksort (izq)
         quickSortRecu(datos,ini,iPivote - 1);
         //quicksort (der)
         quickSortRecu(datos, iPivote + 1, fin);
         
      }
   }
 }
