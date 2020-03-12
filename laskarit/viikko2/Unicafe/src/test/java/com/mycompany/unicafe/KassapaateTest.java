/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stjvaini
 */
public class KassapaateTest {

    Kassapaate kassapaate;

    public KassapaateTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luotuKassapaateRahaOikein() {
        assertEquals(100000, kassapaate.kassassaRahaa());

    }

    @Test
    public void luotuKassapaateMaukkaitaOikein() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());

    }

    @Test
    public void luotuKassapaateEdullisiaOikein() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());

    }

    @Test
    public void kateisOstoMaukasKassaOikein() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisOstoMaukasVaihtorahaOikein() {
        int vaihtoraha = kassapaate.syoMaukkaasti(500);
        assertEquals(100, vaihtoraha);
    }

    @Test
    public void kateisOstoMaukasMaaraOikein() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisOstoMaukasEiRahaaKassaOikein() {
        kassapaate.syoMaukkaasti(300);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisOstoMaukasEiRahaaVaihtorahaOikein() {
        int vaihtoraha = kassapaate.syoMaukkaasti(300);
        assertEquals(300, vaihtoraha);
    }

    @Test
    public void kateisOstoMaukasEiRahaaMaaraOikein() {
        kassapaate.syoMaukkaasti(300);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisOstoEdullinenKassaOikein() {
        kassapaate.syoEdullisesti(500);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisOstoEdullinenVaihtorahaOikein() {
        int vaihtoraha = kassapaate.syoEdullisesti(300);
        assertEquals(60, vaihtoraha);
    }

    @Test
    public void kateisOstoEdullinenMaaraOikein() {
        kassapaate.syoEdullisesti(300);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisOstoEdullinenEiRahaaKassaOikein() {
        kassapaate.syoEdullisesti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kateisOstoEdullinenEiRahaaVaihtorahaOikein() {
        int vaihtoraha = kassapaate.syoEdullisesti(200);
        assertEquals(200, vaihtoraha);
    }

    @Test
    public void kateisOstoEdullinenEiRahaaMaaraOikein() {
        kassapaate.syoEdullisesti(200);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kortilleLadataanRahaaKorttiOikein() {
        Maksukortti kortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, 10);
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void kortilleLadataanRahaaKassaOikein() {
        Maksukortti kortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, 10);
        assertEquals(100010, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortilleLadataanNegatiivinenKassaOikein() {
        Maksukortti kortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, -10);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortillaOstetaanEdullinenKorttiOikein() {
        Maksukortti kortti = new Maksukortti(500);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(260, kortti.saldo());
    }

    @Test
    public void kortillaOstetaanEdullinenKassaOikein() {
        Maksukortti kortti = new Maksukortti(500);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortillaOstetaanEdullinenMaaraOikein() {
        Maksukortti kortti = new Maksukortti(500);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kortillaOstetaanMaukasKorttiOikein() {
        Maksukortti kortti = new Maksukortti(500);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void kortillaOstetaanMaukasKassaOikein() {
        Maksukortti kortti = new Maksukortti(500);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortillaOstetaanMaukasMaaraOikein() {
        Maksukortti kortti = new Maksukortti(500);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortillaOstetaanEdullinenEiRahaaKorttiOikein() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());
    }

    @Test
    public void kortillaOstetaanEdullinenEiRahaaKassaOikein() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortillaOstetaanEdullinenEiRahaaMaaraOikein() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kortillaOstetaanMaukasEiRahaaKorttiOikein() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());
    }

    @Test
    public void kortillaOstetaanMaukasEiRahaaKassaOikein() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortillaOstetaanMaukasEiRahaaMaaraOikein() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
}
