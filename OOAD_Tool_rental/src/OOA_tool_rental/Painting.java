package OOA_tool_rental;

import OOA_tool_rental.Painting.Tool;

import java.util.Objects;

public class Painting extends Inventory implements Protective_GEAR_PACKAGE,Accessory_kit,Extension_cord{
	public enum Tool {
		PAINT_CAN,TRAY,ROLLER,TAPE,PAINT_BRUSH
	}
    private Tool tool;
    private int price;
    private int accessory_price;
	public Painting(String id, String name, Tool tool) {
		super(id);
        Objects.requireNonNull(tool, "tool is required");
        this.tool = tool;
        this.price =50;
        this.accessory_price=0;
		
	}
	public Tool getName() {
        return tool;
    }
	public int getPrice() {
		return price;
	}
	@Override
	public void add_extension_cord() {
		this.accessory_price+=10;
		
	}
	@Override
	public void add_accessory_kit() {
		this.accessory_price+=10;
		
	}
	@Override
	public void add_gear_package() {
		this.accessory_price+=10;
		
	}
	public int get_price_accessory_kit() {
		return this.accessory_price;
		
	}
	

}

