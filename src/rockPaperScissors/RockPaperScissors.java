package rockPaperScissors;

import java.util.Objects;

public class RockPaperScissors {
	private ThrowType type;
	
	public RockPaperScissors(ThrowType type) {
		this.type = type;
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RockPaperScissors other = (RockPaperScissors) obj;
		return type == other.type;
	}

	public ThrowType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "" + type;
	}
}
