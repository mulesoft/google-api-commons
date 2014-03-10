/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.api.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.api.client.json.GenericJson;

/***
 * Generic wrapper for classes that extend {@link com.google.api.client.json.GenericJson}
 * Because the GenericJson class from Google's client extends {@link java.util.Map} but
 * still has the structure of a Pojo, Mule's DataMapper cannot handle it as both, Map and Pojo.
 * 
 * Implementations of this class wraps this classes allowing DataMapper to treat them as Pojos
 * @author mariano.gonzalez@mulesoft.com
 *
 * @param <T>
 */
public abstract class BaseWrapper<T extends GenericJson> {

	/**
	 * takes a collection of {@link com.google.api.client.json.GenericJson}
	 * and returns a list of wrappers of class returnClass
	 * @param googles a collection of google objects
	 * @param returnClass the class of the objects returned
	 * @return a list of returnClass
	 */
	public static <T extends BaseWrapper<?>, G extends GenericJson> List<T> valueOf(Collection<G> googles, Class<T> returnClass) {
		if (googles == null || googles.isEmpty()) {
			return new ArrayList<T>();
		}
		
		List<T> result = new ArrayList<T>(googles.size());
		try {
			Constructor<T> constructor = returnClass.getConstructor(googles.iterator().next().getClass());
			for (G google : googles) {
				result.add(constructor.newInstance(google));
			}
		} catch (Exception e) {
			throw new RuntimeException("Could not transform collection", e);
		}
		
		return result;
	}
	
	/**
	 * Returns a new list with the wrapped objects
	 * @param models the wrappers
	 * @param returnClass the return type
	 * @return a list of wrapped objects
	 */
	@SuppressWarnings("unchecked")
	public static <G extends GenericJson, T extends BaseWrapper<?>> List<G> unwrapp(Collection<T> models, Class<G> returnClass) {
		if (models == null || models.isEmpty()) {
			return new ArrayList<G>();
		}
		
		List<G> result = new ArrayList<G>(models.size());

		for (T model: models) {
			result.add((G) model.wrapped());
		}
		
		return result;
	}

	
	protected T wrapped;
	
	public BaseWrapper(T wrapped) {
		if (wrapped == null) {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			try {
				wrapped = clazz.newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException(String.format("null value passed at constructor but an instance of %s could not be created using default constructor", clazz.getCanonicalName()), e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(String.format("null value passed at constructor but default constrcutor of %s doesn't seem public", clazz.getCanonicalName()), e);
			}
			
		}
		this.wrapped = wrapped;
	}

	/**
	 * Returns the wrapped object
	 * @return the wrapped object
	 */
	public T wrapped() {
		return wrapped;
	}
	
}
