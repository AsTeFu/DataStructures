package omsu.atf;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTesterTest {

    private final String[] wordArray = {
            "Топот",
            "А луна канула",
            "Шалаш",
            "А роза упала на лапу Азора",
            "На в лоб, болван!",
            "А в Енисее - синева.",
            "А лис, он умен - крыса сыр к нему носила.",
            "Аргентина манит негра",
            "Дом мод",
            "И городу дорог огород у дороги",
            "Спел Лепс",
            "Тонет енот",
            "SAIPPUAKAUPPIAS"
    };

    @Test
    void testCreate() {
        PalindromeTester tester = new PalindromeTester("топот");
        assertEquals("ТОПОТ", tester.getFormattedWord());
    }

    @Test
    void testCreateEng() {
        PalindromeTester tester = new PalindromeTester("TOPOT");
        assertEquals("TOPOT", tester.getFormattedWord());
    }

    @Test
    void testCreateTire() {
        PalindromeTester tester = new PalindromeTester("А в Енисее - синева.");
        assertEquals("АВЕНИСЕЕСИНЕВА", tester.getFormattedWord());
    }

    @Test
    void testCreateWithSpace() {
        PalindromeTester tester = new PalindromeTester("т о   п о   т ");
        assertEquals("ТОПОТ", tester.getFormattedWord());
    }

    @Test
    void testCreateWithNonLetter() {
        PalindromeTester tester = new PalindromeTester("На в лоб, болван!");
        assertEquals("НАВЛОББОЛВАН", tester.getFormattedWord());
    }

    @Test
    void testCreateWithUnderLine() {
        PalindromeTester tester = new PalindromeTester("На_в_лоб,_болван!");
        assertEquals("НАВЛОББОЛВАН", tester.getFormattedWord());
    }

    @Test
    void testPalindrome() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(wordArray));
        words.forEach(
                word -> {
                    PalindromeTester tester = new PalindromeTester(word);
                    assertTrue(tester.isPalindrome(), tester::testPalindrome);
                });
    }

    @Test
    void testNotPalindrome() {
        String[] notPalindrome = {"Слава", "Университет", "Карантин"};
        ArrayList<String> words = new ArrayList<>(Arrays.asList(notPalindrome));
        words.forEach(
                word -> assertFalse(new PalindromeTester(word).isPalindrome()));
    }

}