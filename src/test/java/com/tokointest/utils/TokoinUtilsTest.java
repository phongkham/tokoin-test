package com.tokointest.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for #{TokoinUtils}.
 *
 * @author Love
 */
@RunWith(MockitoJUnitRunner.class)
public class TokoinUtilsTest {

	@InjectMocks @Spy
	private TokoinUtils underTest;
	
	@SuppressWarnings("static-access")
	@Test
	public void testAddItemInListToMapWithKeyShouldReturnCorrectDataWhenCalled() {
		// given
		List<String> items = List.of("Francisca");

		// when
		LinkedHashMap<String, String> actual = underTest.addItemInListToMapWithKey(items, "name");

		// then
		assertNotNull(actual);
		assertTrue(actual.size() == 1);
		Map.Entry<String, String> entry  = actual.entrySet().iterator().next();
		assertEquals("name_0", entry.getKey());
		assertEquals("Francisca", entry.getValue());
	}
	@SuppressWarnings("static-access")
	@Test
	public void testAddItemInListToMapWithKeyShouldReturnCorrectDataWhenListDataIsEmpty() {
		// given
		List<String> items = List.of();

		// when
		LinkedHashMap<String, String> actual = underTest.addItemInListToMapWithKey(items, "name");

		// then
		assertNotNull(actual);
		assertTrue(actual.isEmpty());
	}
	@SuppressWarnings("static-access")
	@Test
	public void testAddItemInListToMapWithKeyShouldReturnCorrectDataWhenListDataIsNull() {
		// given
		List<String> items = null;

		// when
		LinkedHashMap<String, String> actual = underTest.addItemInListToMapWithKey(items, "name");

		// then
		assertNotNull(actual);
		assertTrue(actual.isEmpty());
	}
}
