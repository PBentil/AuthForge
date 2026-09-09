CREATE TABLE external_accounts (
                                   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                                   user_id UUID NOT NULL
                                       REFERENCES users(id)
                                           ON DELETE CASCADE,

                                   provider VARCHAR(30) NOT NULL,

                                   provider_subject VARCHAR(255) NOT NULL,

                                   email VARCHAR(255),

                                   created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

                                   UNIQUE (provider, provider_subject)
);

CREATE INDEX idx_external_accounts_user
    ON external_accounts(user_id);