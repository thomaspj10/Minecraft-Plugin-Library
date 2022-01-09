package me.thomaspj10.library.api.data;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	
	private boolean isWrapperType(Class<?> clazz) {
	    return clazz.equals(Boolean.class) || 
	        clazz.equals(Integer.class) ||
	        clazz.equals(Character.class) ||
	        clazz.equals(Byte.class) ||
	        clazz.equals(Short.class) ||
	        clazz.equals(Double.class) ||
	        clazz.equals(Long.class) ||
	        clazz.equals(Float.class) ||
	        clazz.equals(String.class);
	}
	
	private FileConfiguration serialize(Data data, Field field, FileConfiguration config) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, SecurityException {
		String name = field.getName();
		
		System.out.println(name);
		
		// The field should be ignored.
		if (field.isAnnotationPresent(IgnoreField.class))
			return config;
		
		Object value = field.get(data);
		
		// Check if the field is an iterable.
		if (value instanceof Collection<?>) {
			Collection<?> iterable = (Collection<?>) value;
			Class<?> iterableClass = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
			
			// Check if the class is a primative type.
			if (iterableClass.isPrimitive() || isWrapperType(iterableClass)) {
				config.set(name, value);
				return config;
			}
			
			// Check if the class is a Data type.
			if (Data.class.isAssignableFrom(iterableClass)) {
				List<FileConfiguration> items = new ArrayList<>();
				
				for (Object item : iterable) {
					Data dataItem = (Data) item;
					
					FileConfiguration section = new YamlConfiguration();
					for (Field newField : dataItem.getClass().getFields()) {
						section = serialize(dataItem, newField, section);
					}
					
					items.add(section);
				}
				
				config.set(name, items);
				return config;
			}
		}
		
		// Check if the field is a primative type.
		if (field.getType().isPrimitive() || isWrapperType(field.getType())) {
			config.set(name, value);
			return config;
		}
		
		// Check if the field is a Data type.
		if (Data.class.isAssignableFrom(field.getType())) {
			Data valueData = (Data) value;
			
			FileConfiguration section = new YamlConfiguration();
			for (Field newField : valueData.getClass().getFields()) {
				section = serialize(valueData, newField, section);
			}
			
			config.set(name, section);
			return config;
		}
		
		return config;
	}
	
	private void deserialize(Data data, Field field, MemorySection config) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException, ClassNotFoundException {
		String name = field.getName();
		
		// The field should be ignored.
		if (field.isAnnotationPresent(IgnoreField.class))
			return;
		
		if (!config.contains(name))
			return;
		
		Object value = config.get(name);
		
		// Check if the field is an iterable.
		if (config.isList(name)) {
			Collection<?> iterable = (Collection<?>) value;
			Class<?> iterableClass = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
			
			// Check if the class is a primative type.
			if (iterableClass.isPrimitive() || isWrapperType(iterableClass)) {
				field.set(data, value);
			}
			
			// Check if the class is a Data type.
			if (Data.class.isAssignableFrom(iterableClass)) {
				List<Data> items = new ArrayList<>();
				
				for (Object item : iterable) {
					Data dataValue = (Data) iterableClass.getConstructor().newInstance();
					
					// This is a really hack solution to convert a Map<?, ?> to a MemorySection.
					MemorySection section = (MemorySection) config.createSection("CaZlO6Rw4SaC5wLdavCqeDkmqI1vN95cJdwNdPe4CdQmQTTr0GXMjJt0vGwYQzdG", (Map<?,?>) item);
					
					for (Field newField : dataValue.getClass().getFields()) {
						this.deserialize(dataValue, newField, section);
					}
					
					items.add(dataValue);
				}
				
				field.set(data, items);
			}
		}
		
		// Check if the field is a primative type.
		if (field.getType().isPrimitive() || isWrapperType(field.getType())) {
			field.set(data, value);
		}
		
		// Check if the field is a Data type.
		if (Data.class.isAssignableFrom(field.getType())) {
			Data dataValue = (Data) field.getType().getConstructor().newInstance();
			
			MemorySection section = (MemorySection) config.getConfigurationSection(name);
			for (Field newField : dataValue.getClass().getFields()) {
				this.deserialize(dataValue, newField, section);
			}
			
			field.set(data, dataValue);
		}
	}
	
	protected void save(File file) {
		FileConfiguration config = new YamlConfiguration();
		
		for (Field field : this.getClass().getFields()) {
			try {
				config = this.serialize(this, field, config);
			} catch (IllegalArgumentException | IllegalAccessException | ClassNotFoundException | SecurityException e) {
				e.printStackTrace();
			}
		}
		
		if (!file.exists()) {
		    try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void load(File file) {
		if (!file.exists()) {
			this.save(file);
			return;
		}
		
		FileConfiguration config = new YamlConfiguration();
		try {
			config.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		for (Field field : this.getClass().getFields())
			try {
				this.deserialize(this, field, config);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InstantiationException | InvocationTargetException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
}
