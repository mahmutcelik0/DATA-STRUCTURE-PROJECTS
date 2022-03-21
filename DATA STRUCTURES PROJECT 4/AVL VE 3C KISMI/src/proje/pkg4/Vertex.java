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
// Vertex sınıfı tanımlanmıştır.
public class Vertex
   {
   public char label;        // Etiket
   public boolean wasVisited; // Ziyaret edildi mi?
// ------------------------------------------------------------
   public Vertex(char lab)   // Yapılandırıcı metot.
      {
      label = lab;
      wasVisited = false;
      }
// ------------------------------------------------------------
   }  // Vertex sınıfının sonu.
////////////////////////////////////////////////////////////////
