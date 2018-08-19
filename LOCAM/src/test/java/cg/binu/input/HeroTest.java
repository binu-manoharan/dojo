package cg.binu.input;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HeroTest {

    private static final int HERO_HEALTH = 30;
    private static final int HERO_MANA = 1;

    @Test
    public void should_create_a_hero() throws Exception {
        final Hero hero = new Hero(HERO_HEALTH, HERO_MANA);
        assertThat("Hero has 30 health.", hero.getHealth(), is(HERO_HEALTH));
        assertThat("Hero has 1 mana.", hero.getMana(), is(HERO_MANA));
    }
}
