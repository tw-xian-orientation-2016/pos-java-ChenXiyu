package test_main;

import main.good;
import main.pos;
import org.junit.Test;

import java.util.ArrayList;

import static main.pos.CountintNumber;

public class countingNumber {
    String[] barcodes = new String[]{"ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000003-2", "ITEM000005", "ITEM000005", "ITEM000005"};
    @Test
    public void counting_barcode_Number_when_using_countingNumber() {
        pos p = new pos();
        ArrayList<good> goods = pos.CountintNumber(barcodes);

        for (int i = 0; i <goods.size() ; i++) {
            System.out.println(goods.get(i).barcode);
            System.out.println(goods.get(i).count);
        }
    }
}
