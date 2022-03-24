package IHS;

import org.junit.jupiter.api.Assertions;

import static IHS.Main.findAllPalindromes;

class MainTest {

    @org.junit.jupiter.api.Test
    void returningLongestPalindromeFirst() {
        Assertions.assertEquals("ILOVEUEVOLI", findAllPalindromes("ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD").get(0));
    }

    @org.junit.jupiter.api.Test
    void returningShortestPalindromeFirst() {
        Assertions.assertEquals("GG", findAllPalindromes("ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD").get(10));
    }

    @org.junit.jupiter.api.Test
    void containsNoPalindrome() {
        Assertions.assertEquals(0, findAllPalindromes("helo").size());
    }
}