package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());

    }

    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());

    }

    @Test
    public void SaldoVaheneeOikein1() {
        kortti.otaRahaa(1);

        assertEquals("saldo: 0.9", kortti.toString());

    }

    @Test
    public void SaldoVaheneeOikein2() {
        kortti.otaRahaa(10);

        assertEquals("saldo: 0.0", kortti.toString());

    }

    @Test
    public void SaldoEiMuutu() {
        kortti.otaRahaa(20);

        assertEquals("saldo: 0.10", kortti.toString());

    }

    @Test
    public void rahaRiitti() {
        assertTrue(kortti.otaRahaa(10));

    }

    @Test
    public void rahaEiRiittänyt() {
        assertFalse(kortti.otaRahaa(20));

    }

    @Test
    public void saldoOikein() {
        assertEquals(10, kortti.saldo());
    }

}
