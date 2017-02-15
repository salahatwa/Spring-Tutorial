package com.z2data.browser;

public enum StatusMap {
	VALID(2), INVALID(11), BROKEN(3), SERVER_ISSUE(7), Agent_ISSUE(5), REDIRECT(4);
	private long id;

	private StatusMap(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
