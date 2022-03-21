/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg4;

/**
 *
 * @author Özgür Bayraşa
 */
// StackX Sınıfı tanımlanmıştır.
public class StackX
   {
   // Stack'in boyutu 20 birimdir. Bunun dışında özellikler de tanımlanmıştır.
   private final int SIZE = 20;
   private int[] st; // Stack dizisi.
   private int top; // Tepedeki eleman.
// ------------------------------------------------------------
// Yapılandırıcı metot tanımlanmıştır.
   public StackX()           
      {
      st = new int[SIZE];    // Dizi boyut kadar oluşturulmuştur.
      top = -1;  // Henüz eleman olmadığı için tepedeki değer -1'dir.
      }
// ------------------------------------------------------------
// Stack'e eleman eklenen metot tanımlanmıştır.
   public void push(int j)
      { 
          st[++top] = j; // Tepe değer bir arttırılır ve eleman eklenir. 
      }
// ------------------------------------------------------------
// Stack'ten eleman  alınan metot tanımlanmıştır.
   public int pop()         
      { 
          return st[top--]; // Tepedeki eleman döndürülür ve tepe indeks 
                            // azalrılır.
      }
// ------------------------------------------------------------
   // Tepedeki elemanı döndüren metottur.
   public int peek()         
      { 
          return st[top];
      }
// ------------------------------------------------------------
// Stack'te elemena olup olmadığını kontrol eden metottur.
   public boolean isEmpty()  
      { 
       return (top == -1); 
   }
// ------------------------------------------------------------
   }  // StackX sınıfınını sonu.
////////////////////////////////////////////////////////////////