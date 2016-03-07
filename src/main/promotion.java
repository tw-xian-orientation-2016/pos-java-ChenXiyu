package main;

import java.util.ArrayList;

public class promotion {
    public String type;
    public String[] barcodes;
    public static ArrayList<promotion> loadAllPromotions(){
        promotion p = new promotion();
        p.type = "BUY_TWO_GET_ONE_FREE";
        p.barcodes =new String[]{"ITEM000000","ITEM000001"};
        ArrayList<promotion> promotions = new ArrayList<promotion>();
        promotion p2 = new promotion();
        promotions.add(p);
        p2.type = "OTHER_PROMOTION";
        p2.barcodes =new String[]{"ITEM000003","ITEM000004"};
        promotions.add(p2);
        return promotions;
    }
}
