package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Flower[][] flowers = new Flower[8][8];

    public void start() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                flowers[i][j] = new Flower();
                flowers[i][j].setX(i);
                flowers[i][j].setY(j);
            }
        }




        Insect f = new Insect();
        Insect f1 = new Insect();
        Insect f2 = new Insect();
        Insect f3 = new Insect();
        Insect f4 = new Insect();
        Insect f5 = new Insect();
        Insect f6 = new Insect();
        Gardener gardener = new Gardener();

        f.setX(new Random().nextInt(8));
        f.setY(new Random().nextInt(8));

        f1.setX(new Random().nextInt(8));
        f1.setY(new Random().nextInt(8));

        f2.setX(new Random().nextInt(8));
        f2.setY(new Random().nextInt(8));

        f3.setX(new Random().nextInt(8));
        f3.setY(new Random().nextInt(8));

        f4.setX(new Random().nextInt(8));
        f4.setY(new Random().nextInt(8));

        f5.setX(new Random().nextInt(8));
        f5.setY(new Random().nextInt(8));

        f6.setX(0);
        f6.setY(0);

        List<String> insects = new ArrayList<>();

        insects.add(f.getPos());
        insects.add(f1.getPos());
        insects.add(f2.getPos());
        insects.add(f3.getPos());
        insects.add(f4.getPos());
        insects.add(f5.getPos());
        insects.add(f6.getPos());


        System.out.println(gardener.getPos());
        System.out.println(insects);

        insects.remove(f.getPos());
        insects.remove(f1.getPos());
        insects.remove(f2.getPos());
        insects.remove(f3.getPos());
        insects.remove(f4.getPos());
        insects.remove(f5.getPos());
        insects.remove(f6.getPos());
        /*System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();
        f6.move();



        insects.add(f.getPos());
        insects.add(f1.getPos());
        insects.add(f2.getPos());
        insects.add(f3.getPos());
        insects.add(f4.getPos());
        insects.add(f5.getPos());
        insects.add(f6.getPos());

        System.out.println(insects);

        if(f.getPos().equals(gardener.getPos())) {
            insects.remove(f);
        }
        if(f1.getPos().equals(gardener.getPos())) {
            insects.remove(f1);
        }
        if(f2.getPos().equals(gardener.getPos())) {
            insects.remove(f2);
        }
        if(f3.getPos().equals(gardener.getPos())) {
            insects.remove(f3);
        }
        if(f4.getPos().equals(gardener.getPos())) {
            insects.remove(f4);
        }
        if(f5.getPos().equals(gardener.getPos())) {
            insects.remove(f5);
        }
        if(f6.getPos().equals(gardener.getPos())) {
            insects.remove(f6);
        }

        System.out.println(gardener.getPos());
        System.out.println(insects);

    /*    System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();



     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

       /* System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

   /*     System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

   /*     System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */

        gardener.move();
        f.move();
        f1.move();
        f2.move();
        f3.move();
        f4.move();
        f5.move();

     /*   System.out.println("A kertész pozíciója : " + gardener.getPos());
        System.out.println("Az 0. rovar pozíciója : " + f.getPos());
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());
        System.out.println("Az 2. rovar pozíciója : " + f2.getPos());
        System.out.println("Az 3. rovar pozíciója : " + f3.getPos());
        System.out.println("Az 4. rovar pozíciója : " + f4.getPos());
        System.out.println("Az 5. rovar pozíciója : " + f5.getPos()); */


    /*    f1.move();
        System.out.println("Az 1. rovar pozíciója : " + f1.getPos());


        System.out.println("A rovar pozíciója : " + f6.getPos());



        System.out.println(flowers[0][0].getHealth());
        System.out.println(flowers[0][0].death()); */












    }
}
