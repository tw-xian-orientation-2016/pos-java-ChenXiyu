package main;

import java.util.ArrayList;

/**
 * Created by cxy on 3/6/16.
 */
public class item {
    public String barcode;
    public String name;
    public String unit;
    public double price;
    public item(String barcode , String name , String unit , double price){
        this.barcode = barcode;
        this.name =name;
        this.price =price;
        this.unit =unit;
    }

    public item(){}

    public static ArrayList<item> loadAllItems(){
        ArrayList<item> items = new ArrayList<item>();

        items.add(new item("ITEM000000","可口可乐","瓶", 3.00));
        items.add(new item("ITEM000001","雪碧","瓶", 3.00));
        items.add(new item("ITEM000002","苹果","斤", 5.50));
        items.add(new item("ITEM000003","荔枝","斤", 15.00));
        items.add(new item("ITEM000004","电池","个", 2.00));
        items.add(new item("ITEM000005","方便面","袋", 4.50));
        return items;
    }
}
