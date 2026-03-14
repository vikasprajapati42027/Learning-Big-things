-- Check if query uses index
EXPLAIN SELECT name, email FROM users WHERE last_name = 'Vikas' AND status = 'ACTIVE';

-- 1. Composite Index (Order matters! last_name first)
CREATE INDEX idx_user_name_status ON users(last_name, status);

-- 2. Covering Index (Include 'email' in the index so DB doesn't have to touch the data row)
CREATE INDEX idx_full_search ON users(last_name, status, email);

-- 3. Partial Index (MySQL 8.0.13+)
-- Useful for large tables where you only search "active" rows
CREATE INDEX idx_active_users ON users(last_name) WHERE status = 'ACTIVE';
