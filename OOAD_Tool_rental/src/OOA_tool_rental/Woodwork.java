package OOA_tool_rental;

import OOA_tool_rental.Woodwork.Tool;

import java.util.Objects;

public class Woodwork extends Inventory implements Protective_GEAR_PACKAGE,Accessory_kit,Extension_cord,Cost_accessory{
	public enum Tool {
		HAMMER,KNIFE,CHISEL,NAIL,SLIDING_BEVEL
	}
	private int price;
    private Tool tool;
    private int accessory_price;
	public Woodwork(String id, String name, Tool tool) {
		super(id);
        Objects.requireNonNull(tool, "tool is required");

       
        this.tool = tool;
        this.price =80;
		
	}
	public Tool getName() {
        return tool;
    }
	public int getPrice() {
		return price;
	}
	@Override
	public void add_extension_cord() {
		this.accessory_price+=18;
		
	}
	@Override
	public void add_accessory_kit() {
		this.accessory_price+=18;
		
	}
	@Override
	public void add_gear_package() {
		this.accessory_price+=18;
		
	}
	@Override
	public int get_price_accessory_kit() {
		return this.accessory_price;
		
	}

	

}

