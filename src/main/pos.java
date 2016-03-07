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

    public static ArrayList<receiptItem> countingPromotions(ArrayList<cartItem> cartItems , ArrayList<promotion> promotions){
        double saved = 0;
        ArrayList<receiptItem> receiptItems = new ArrayList<receiptItem>();
        for (int i = 0; i < cartItems.size(); i++) {
            if("BUY_TWO_GET_ONE_FREE".equals(getPromotionType(promotions,cartItems.get(i).item.barcode))){
                saved = (int)(cartItems.get(i).count / 3.0)*cartItems.get(i).item.price;
            }else{
                saved = 0;
            }
            receiptItems.add(new receiptItem(cartItems.get(i),saved));
        }
        return receiptItems;
    }

    private  static String getPromotionType(ArrayList<promotion> promotions , String barcode){
        for (int i = 0; i < promotions.size() ; i++) {
            for (int j = 0; j < promotions.get(i).barcodes.length ; j++) {
                if(promotions.get(i).barcodes[j].equals(barcode)){
                    return promotions.get(i).type;
                }
            }
        }
        return "";
    }

    public static String format(ArrayList<receiptItem> receiptItes){
        String result = "***<没钱赚商店>收据***\n";
        double total = 0 , totalSaved = 0;
        double subtotal;
        for (int i = 0; i < receiptItes.size(); i++) {
            subtotal = 0;
            result += "名称：" + receiptItes.get(i).cartitem.item.name + "，";
            result += "数量：" + receiptItes.get(i).cartitem.count + receiptItes.get(i).cartitem.item.unit + "，";
            result += "单价：" + receiptItes.get(i).cartitem.item.price + "（元）" + "，";
            subtotal = (receiptItes.get(i).cartitem.item.price  * receiptItes.get(i).cartitem.count - receiptItes.get(i).saved);
            result += "小计：" +subtotal + "（元）" + "\n";
            total += subtotal;
            totalSaved += receiptItes.get(i).saved;
        }
        result += "----------------------\n";
        result += "总计：" + total + "\n";
        result += "节省：" + totalSaved +"\n";
        result += "**********************\n";
        return result;
    }
}
