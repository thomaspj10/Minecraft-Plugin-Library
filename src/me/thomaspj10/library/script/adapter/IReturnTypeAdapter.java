package me.thomaspj10.library.script.adapter;

public interface IReturnTypeAdapter<fromType, toType extends IAdaptable<fromType>> {

	public Class<fromType> getFromType();
	
	public toType transform(fromType object);
	
}
