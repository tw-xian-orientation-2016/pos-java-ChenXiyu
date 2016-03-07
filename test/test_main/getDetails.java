package test_main;

import main.cartItem;
import main.good;
import main.item;
import main.pos;
import org.junit.Test;

import java.util.ArrayList;

public class getDetails {
    @Test
    public void GetDetails_when_input_goods(){
        ArrayList<item> items = item.loadAllItems();
        ArrayList<good> goods = new ArrayList<good>();
        goods.add(new good("ITEM000001", 5.0));
        goods.add(new good("ITEM000003", 2.0));
        goods.add(new good("ITEM000005", 3.0));

        ArrayList<cartItem> cartItems = pos.getDetails(goods,items);

        for (int i = 0; i <cartItems.size() ; i++) {
            System.out.println(cartItems.get(i).item.name);
            System.out.println(cartItems.get(i).count);
        }
    }
}
