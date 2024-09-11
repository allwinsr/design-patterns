package com.allwin.ds.recursion;

public class TowersOfHanoi {


    public static void main(String[] args) {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        int n = 4;
        towersOfHanoi.move(n, 'A', 'B', 'C');
    }

    private void move(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + from + " to " + to);
            return;
        }
        move(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        move(n - 1, aux, to, from);
    }
}
