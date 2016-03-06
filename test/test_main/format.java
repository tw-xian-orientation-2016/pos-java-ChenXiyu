package test_main;

import main.cartItem;
import main.item;
import main.pos;
import main.receiptItem;
import org.junit.Test;

import java.util.ArrayList;

public class format {
    @Test
    public void format_the_receipt(){
        ArrayList<receiptItem> receipts = new ArrayList<receiptItem>();
        receipts.add(new receiptItem(new cartItem(new item("ITEM000000","可口可乐","瓶", 3.00),5.0),3.00));
        receipts.add(new receiptItem(new cartItem(new item("ITEM000001","雪碧","瓶", 3.00),3.0),3.00));
        receipts.add(new receiptItem(new cartItem(new item("ITEM000002","苹果","斤", 4.50),2.0),0.00));
        String result = pos.format(receipts);
        System.out.print(result);
    }
}
