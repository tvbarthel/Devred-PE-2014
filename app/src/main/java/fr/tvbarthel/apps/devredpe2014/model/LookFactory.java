package fr.tvbarthel.apps.devredpe2014.model;


import fr.tvbarthel.apps.devredpe2014.R;

public class LookFactory {

    // Non instantiable class.
    private LookFactory() {
    }

    public static Look create1() {
        return new Look(R.drawable.r_look_1, R.drawable.look_1, LookItemFactory.createForLook1());
    }

    public static Look create2() {
        return new Look(R.drawable.r_look_2, R.drawable.look_2, LookItemFactory.createForLook2());
    }

    public static Look create3() {
        return new Look(R.drawable.r_look_3, R.drawable.look_3, LookItemFactory.createForLook3());
    }

    public static Look create4() {
        return new Look(R.drawable.r_look_4, R.drawable.look_4, LookItemFactory.createForLook4());
    }

    public static Look create6() {
        return new Look(R.drawable.r_look_6, R.drawable.look_6, LookItemFactory.createForLook6());
    }

    public static Look create7() {
        return new Look(R.drawable.r_look_7, R.drawable.look_7, LookItemFactory.createForLook7());
    }

    public static Look create8() {
        return new Look(R.drawable.r_look_8, R.drawable.look_8, LookItemFactory.createForLook8());
    }

    public static Look create9() {
        return new Look(R.drawable.r_look_9, R.drawable.look_9, LookItemFactory.createForLook9());
    }

    public static Look create10() {
        return new Look(R.drawable.r_look_10, R.drawable.look_10, LookItemFactory.createForLook10());
    }
}
