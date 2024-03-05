package org.example.twoOne_switch_patterns.module_one.l_2;

sealed interface CardClassification permits Suit, Tarot {}
enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
final class Tarot implements CardClassification {}
public class Main {

    static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
        switch (c) {
            case Suit s when s == Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit s when s == Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit s when s == Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit s -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }
}
