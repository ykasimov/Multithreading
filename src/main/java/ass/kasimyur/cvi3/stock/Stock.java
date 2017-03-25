package ass.kasimyur.cvi3.stock;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * Stock pojo
 */
public class Stock {

	protected String code;
	protected float value;
	
	public Stock(@Nonnull String code, @Nonnegative float value) {
		this.code = code;
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}

	public float getValue() {
		return value;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + Float.floatToIntBits(value);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		return true;
	}
}
