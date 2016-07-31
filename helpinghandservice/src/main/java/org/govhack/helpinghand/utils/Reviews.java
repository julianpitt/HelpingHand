package org.govhack.helpinghand.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by James on 30-Jul-16.
 */
public class Reviews {
    List<String> listOfReviews;
    public Reviews() {
        listOfReviews = Arrays.asList(
                "Mint mentos: 8/10\n Fruity mentos: 8/10\nMint mentos with rice: 6/10\n Fruity mentos with rice: 7/10\n Thank you for your suggestion.", "Fruity Pebbles + milk: 9/10\n Fruity Pebbles + milk over rice: 8/10\n It's like fruity rice milk!\n Thank you for your suggestion.", "Jelly beans: 8/10\n" +
                "Jelly beans with rice: 4/10\n Little too weird on the textures and not the best flavors either.",
                "Smores ice cream: 10/10\n Smores ice cream over rice: 5/10\n Sort of a weird taste when put together, not too pleasant.",
                "Slice of pumpkin pie: 9/10\n Slice of pumpkin pie with rice: 7/10\n Like peanut butter, this really masks the rice and doesn't change it too much.",
                "Don't need to go to the store for this one!\n Leftover spaghetti from 2 nights ago.\n Spaghetti= 10/10\n Spaghetti over rice = 9/10, tastes good but is sort of a weird blend together.\n",
                "Orange juice: 10/10\n Orange juice with rice: 3/10\n I don't think most drinks are good with rice.",
                "Jello: 10/10\n Jello with rice: 8/10\n This really should be a thing.",
                "Mac and cheese with rice: 9/10\n Mac and cheese with rice with rice: 9/10\n Haha I'm so funny no I'm not but it was pretty good would reccomend.",
                "Carrot cake: 10/10\n Carrot cake with rice: 6/10\n Tastes pretty bad, but can cake ever really be that bad?",
                "Skittles: 10/10 one of the best wonders of life.\n Skittles with rice: 7/10\n Weird combination but isn't too bad.",
                "Nutella: 10/10\n Nutella with rice: 10/10\n This is pretty damn good.",
                "Hot dog: 8/10\n Hot dog with rice in the bun: 8/10\n This is pretty good, would reccomend for anyone wanting to try something different."); }

    public String getReview() {
        Random rand = new Random();
        String review = "";
        try {
            review = listOfReviews.get(rand.nextInt((listOfReviews.size() - 0) + 1));

        } catch (Exception ex) {
            review = listOfReviews.get(0);
        }
        return review;
    }
}
