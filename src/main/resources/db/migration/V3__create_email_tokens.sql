CREATE TABLE email_tokens (
                              id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                              user_id UUID NOT NULL
                                  REFERENCES users(id)
                                      ON DELETE CASCADE,

                              type VARCHAR(30) NOT NULL,

                              token_hash VARCHAR(255) NOT NULL UNIQUE,

                              expires_at TIMESTAMPTZ NOT NULL,

                              used_at TIMESTAMPTZ
);