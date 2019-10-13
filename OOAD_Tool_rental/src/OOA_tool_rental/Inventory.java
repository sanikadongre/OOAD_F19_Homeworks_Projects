package OOA_tool_rental;
import java.util.Objects;

public abstract class Inventory {
	/*Tool rental base inventory class*/
	private final String id;
	protected Inventory(String id) {
		Objects.requireNonNull(id,"ID cannot be null");
		this.id=id;
	}
	public String getID() {
		return id;
	}

}
