package main;

public class receiptItem {
    public cartItem cartitem;
    public double saved;
    public receiptItem(cartItem c,double s){
        this.cartitem = c;
        this.saved = s;
    }
}
