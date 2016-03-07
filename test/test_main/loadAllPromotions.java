package test_main;

import main.promotion;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static sun.nio.cs.Surrogate.is;

public class loadAllPromotions {
    @Test
    public void loadAllPromotions_test(){
        promotion p = new promotion();
        promotion p1 = new promotion();
        promotion p2 = new promotion();

        p1.type = "BUY_TWO_GET_ONE_FREE";
        p1.barcodes =new String[]{"ITEM000000","ITEM000001"};
        ArrayList<promotion> expectPromotions = new ArrayList<promotion>();
        expectPromotions.add(p1);
        p2.type = "OTHER_PROMOTION";
        p2.barcodes =new String[]{"ITEM000003","ITEM000004"};
        expectPromotions.add(p2);

        ArrayList<promotion> promotions = p.loadAllPromotions();
        for (int i = 0; i <promotions.size() ; i++) {
            System.out.println(promotions.get(i).type);
            System.out.println(promotions.get(i).barcodes[0]);
            System.out.println(promotions.get(i).barcodes[1]);
        }
//      assertSame(promotions,expectPromotions);

 //       assertEquals(true,(promotions.equals(expectPromotions)));
    }
}
