package main;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by cxy on 3/6/16.
 */
public class pos {
    public static ArrayList<good> CountintNumber(String[] barcodes){
        ArrayList<good>  goods = new ArrayList<good>();
        double count;
        int index;
        for (int i = 0; i <barcodes.length ; i++) {
            String[] part = barcodes[i].split("-");
            if (part.length<2){
                count=1;
            }else{
                count= Double.parseDouble(part[1]);
            }
            if ((index = inGoods(goods,part[0])) != -1 ){
                goods.get(index).count += count;
            }else{
                goods.add(new good(part[0],count));
            }
        }
        return goods;
    }

    private static int inGoods( ArrayList<good> goods , String barcode){
        for (int i = 0; i < goods.size() ; i++) {
            if (goods.get(i).barcode.equals(barcode)){
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<cartItem> getDetails(ArrayList<good> goods ,ArrayList<item> items) {
        ArrayList<cartItem> cartItems = new ArrayList<cartItem>();
        for (int i = 0; i < goods.size() ; i++) {
            for (int j = 0; j <items.size() ; j++) {
                if (goods.get(i).barcode.equals(items.get(j).barcode)){
                    cartItems.add(new cartItem(items.get(i),goods.get(i).count));
                }
            }
        }
        return cartItems;
    }
}
