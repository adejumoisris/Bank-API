package com.example.bankapi.service;

import com.example.bankapi.model.AuditLog;
import com.example.bankapi.repository.AuditLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {
    private static final Logger log = LoggerFactory.getLogger(AuditLogService.class);
    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void logAction(String userId,
                          String action,
                          String resource,
                          String status,
                          String ipAddress) {
        AuditLog auditLog1 = new AuditLog();
        auditLog1.setUserId(userId);
        auditLog1.setAction(action);
        auditLog1.setResource(resource);
        auditLog1.setStatus(status);
        auditLog1.setIpAddress(ipAddress);
        auditLogRepository.save(auditLog1);

        log.info("AUDIT | user={} action={} resource={} status={}",
                userId, action, resource, status);
    }
}
