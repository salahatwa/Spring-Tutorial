package com.z2data.browser;

public class Status {

	public long getStatus(int code) {
		switch (code) {
		case -1:
			return StatusMap.INVALID.getId();
		case 200:
		case 206:
			return StatusMap.VALID.getId();
		case 300:
		case 301:
		case 302:
		case 303:
		case 307:
		case 308:
			return StatusMap.REDIRECT.getId();
		case 400:
		case 404:
		case 405:
			return StatusMap.BROKEN.getId();
		case 500:
		case 502:
		case 503:
		case 505:
			return StatusMap.SERVER_ISSUE.getId();
		case 408:
		case 403:
		case 429:
		default:
			return StatusMap.Agent_ISSUE.getId();
		}
	}
}
