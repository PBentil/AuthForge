CREATE TABLE audit_logs (
                            id BIGSERIAL PRIMARY KEY,

                            user_id UUID
                                REFERENCES users(id),

                            event VARCHAR(50) NOT NULL,

                            ip_address INET NOT NULL,

                            user_agent TEXT,

                            metadata JSONB,

                            created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_audit_logs_user
    ON audit_logs(user_id, created_at DESC);

CREATE INDEX idx_audit_logs_ip
    ON audit_logs(ip_address, created_at DESC);