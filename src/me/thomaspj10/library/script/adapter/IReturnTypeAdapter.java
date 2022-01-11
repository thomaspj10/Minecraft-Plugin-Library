package me.thomaspj10.library.script.adapter;

public interface IReturnTypeAdapter<fromType, toType extends IAdaptable<fromType>> {
	
	/**
	 * Returns the Class<fromType> of the from type.
	 * @return Class<fromType>
	 */
	public Class<fromType> getFromType();
	
	/**
	 * Transform the from object to the to object.
	 * @param object
	 * @return The toType.
	 */
	public toType transform(fromType object);
	
}
