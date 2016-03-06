package test_main;

import main.item;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by cxy on 3/6/16.
 */
public class loadAllItems {
    @Test
    public void return_correct_array_when_use_loadallItems(){
        item i = new item();
        ArrayList<item>  expectItems= i.loadAllItems();
        ArrayList<item>  items= new ArrayList<item>();

        items.add(new item("ITEM000000","可口可乐","瓶", 3.00));
        items.add(new item("ITEM000001","雪碧","瓶", 3.00));
        items.add(new item("ITEM000002","苹果","斤", 5.50));
        items.add(new item("ITEM000003","荔枝","斤", 15.00));
        items.add(new item("ITEM000004","电池","个", 2.00));
        items.add(new item("ITEM000005","方便面","袋", 4.50));

        for (int j = 0; j < expectItems.size() ; j++) {
           System.out.println(expectItems.get(j).barcode);
            System.out.println(expectItems.get(j).name);
            System.out.println(expectItems.get(j).price);
            System.out.println(expectItems.get(j).unit);
        }
    }

}
