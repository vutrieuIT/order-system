package com.trieuvd.order.lab.osiv;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("osiv-lab")
public class OsivLabController {

	private final OsivLabService service;

	public OsivLabController(OsivLabService service) {
		this.service = service;
	}

	@GetMapping("/lab/osiv")
	public Map<String, Object> osiv() throws InterruptedException {
		long start = System.currentTimeMillis();
		Object dbTime = service.touchDb();
		long afterTx = System.currentTimeMillis();

		// Giả lập gọi HTTP API ngoài mất 2s, nằm NGOÀI @Transactional.
		Thread.sleep(2000);

		return Map.of(
				"dbTime", String.valueOf(dbTime),
				"txMs", afterTx - start,
				"totalMs", System.currentTimeMillis() - start,
				"thread", Thread.currentThread().getName());
	}

}
