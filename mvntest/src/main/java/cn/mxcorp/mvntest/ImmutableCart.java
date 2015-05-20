package cn.mxcorp.mvntest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cookie
 * @date 2015年5月14日 下午4:43:22
 **/
public class ImmutableCart {
	private final List items;

	public ImmutableCart(List items) {
		this.items = Collections.unmodifiableList(new ArrayList(items));
	}

	public List getItems() {
		return items;
	}

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("element1");
		ImmutableCart cart = new ImmutableCart(list);
		cart.getItems().add("element2");
	}
}
