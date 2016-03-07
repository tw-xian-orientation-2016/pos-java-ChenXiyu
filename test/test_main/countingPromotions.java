package test_main;

import main.*;
import org.junit.Test;

import java.util.ArrayList;

public class countingPromotions {
    @Test
    public void return_cartItem_with_promotion(){
        ArrayList<cartItem> cartItems = new ArrayList<cartItem>();

        cartItems.add(new cartItem(new item("ITEM000000","可口可乐","瓶", 3.00),5.0));
        cartItems.add(new cartItem(new item("ITEM000001","雪碧","瓶", 3.00),3.0));
        cartItems.add(new cartItem(new item("ITEM000002","苹果","斤", 5.50),2.0));

        ArrayList<receiptItem> receiptItems = pos.countingPromotions(cartItems, promotion.loadAllPromotions());

        for (int i = 0; i < receiptItems.size() ; i++) {
            System.out.println(receiptItems.get(i).cartitem.item.name);
            System.out.println(receiptItems.get(i).cartitem.count);
            System.out.println(receiptItems.get(i).saved);
        }
    }
}
