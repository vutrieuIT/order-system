package com.trieuvd.order.lab.osiv;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Profile("osiv-lab")
public class OsivLabService {

	private final EntityManager entityManager;

	public OsivLabService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// Chạm DB để EntityManager lấy connection; transaction commit khi method kết thúc.
	@Transactional(readOnly = true)
	public Object touchDb() {
		return entityManager.createNativeQuery("SELECT now()").getSingleResult();
	}

}
