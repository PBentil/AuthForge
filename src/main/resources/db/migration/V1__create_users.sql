CREATE TABLE users (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                       email VARCHAR(255) NOT NULL UNIQUE,

                       name VARCHAR(100) NOT NULL,

                       password_hash VARCHAR(255) NOT NULL,

                       status VARCHAR(20) NOT NULL DEFAULT 'PENDING_VERIFICATION',

                       failed_logins INTEGER NOT NULL DEFAULT 0,

                       locked_until TIMESTAMPTZ,

                       created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

                       updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);