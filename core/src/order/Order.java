package order;
import java.io.Serializable;
public class Order implements Serializable {
	/**
	 * Class Order 's used to instantiate an order 
	 *  @Example :
	 * 			  0:STORE_MyInfoInServer
	 * 			  1:STORE_PATIENT
	 */
	protected int numOrder;
	public Order(int numOrder) {
		this.numOrder = numOrder;
	}
	public int getNumOrder() {
		return numOrder;
	}
	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}

}









	

