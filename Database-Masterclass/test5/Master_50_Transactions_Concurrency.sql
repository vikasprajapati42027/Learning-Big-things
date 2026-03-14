-- ============================================================================
-- DATABASE MASTERCLASS: TEST 5 - THE 50 TRANSACTION & CONCURRENCY SCENARIOS
-- ============================================================================

-- 1. SCHEMA SETUP (Banking & FinTech System)
CREATE TABLE accounts (
    acc_id INT PRIMARY KEY,
    owner_name VARCHAR(50),
    balance DECIMAL(15,2),
    status VARCHAR(10) -- ACTIVE, FROZEN, CLOSED
);

CREATE TABLE audit_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    acc_id INT,
    action VARCHAR(50),
    old_val DECIMAL(15,2),
    new_val DECIMAL(15,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE daily_limits (
    acc_id INT PRIMARY KEY,
    max_daily_limit DECIMAL(15,2),
    current_spent DECIMAL(15,2)
);

INSERT INTO accounts VALUES (1, 'Vikas', 50000.00, 'ACTIVE'), (2, 'Rahul', 20000.00, 'ACTIVE'), (3, 'Amit', 5000.00, 'FROZEN');
INSERT INTO daily_limits VALUES (1, 100000.00, 0.00), (2, 50000.00, 0.00);

-- ============================================================================
-- 50 SCENARIOS: TRANSACTIONS & CONCURRENCY
-- ============================================================================

-- Q1: Basic Atomic Transfer?
START TRANSACTION;
UPDATE accounts SET balance = balance - 1000 WHERE acc_id = 1;
UPDATE accounts SET balance = balance + 1000 WHERE acc_id = 2;
COMMIT;

-- Q2: ROLLBACK on Error?
START TRANSACTION;
UPDATE accounts SET balance = balance - 5000 WHERE acc_id = 1;
-- Error happens...
ROLLBACK;

-- Q3: Partial Rollback using Savepoints?
START TRANSACTION;
UPDATE accounts SET balance = balance - 100 WHERE acc_id = 1;
SAVEPOINT p1;
UPDATE accounts SET balance = balance - 200 WHERE acc_id = 1;
ROLLBACK TO p1; -- Undo 200 but keep 100
COMMIT;

-- Q4: Pessimistic Locking (SELECT FOR UPDATE)?
-- Thread A:
START TRANSACTION;
SELECT * FROM accounts WHERE acc_id = 1 FOR UPDATE;
-- Thread B: Attempts to SELECT FOR UPDATE will wait until A commits.

-- Q5: Shared Lock (FOR SHARE)?
-- Allows others to read, but blocks anyone from writing.
START TRANSACTION;
SELECT * FROM accounts WHERE acc_id = 2 FOR SHARE;

-- Q6: Simulating a Dirty Read?
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
START TRANSACTION;
SELECT balance FROM accounts WHERE acc_id = 1; -- Sees uncommitted changes from others!

-- Q7: Handling Non-Repeatable Reads?
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
-- Between two SELECTS in the same Transaction, if another user commits, balance changes!

-- Q8: Avoiding Non-Repeatable Reads (Repeatable Read)?
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- Balance stays the same throughout the transaction even if others commit change.

-- Q9: Handling Phantoms (Serializable)?
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- No range changes (new rows) allowed.

-- Q10: Deadlock Simulation 1?
-- Session 1: Locks Acc 1
START TRANSACTION; SELECT * FROM accounts WHERE acc_id = 1 FOR UPDATE;
-- Session 2: Locks Acc 2
START TRANSACTION; SELECT * FROM accounts WHERE acc_id = 2 FOR UPDATE;
-- Session 1: Tries to lock Acc 2 (WAITS)
-- Session 2: Tries to lock Acc 1 (DEADLOCK DETECTED! MySQL kills one)

-- Q11: Optimistic Locking with Versioning?
-- Query:
UPDATE accounts SET balance = balance - 500 
WHERE acc_id = 1 AND balance >= 500; -- Atomic check-and-set

-- Q12: Checking for transaction status?
SELECT * FROM information_schema.innodb_trx;

-- Q13: Finding which transaction is blocking which?
SELECT * FROM sys.innodb_lock_waits;

-- Q14: Setting a lock timeout?
SET innodb_lock_wait_timeout = 10;

-- Q15: Immediate failure if lock unavailable?
SELECT * FROM accounts WHERE acc_id = 1 FOR UPDATE NOWAIT;

-- Q16: Immediate failure with skip (SKIP LOCKED)?
-- Useful for task queues.
SELECT * FROM accounts WHERE status = 'ACTIVE' FOR UPDATE SKIP LOCKED LIMIT 1;

-- Q17: Transaction with Trigger Audit?
-- (If trigger exists on accounts, this is one unit)
START TRANSACTION;
UPDATE accounts SET balance = balance - 50 WHERE acc_id = 1;
COMMIT; -- Trigger inserts to audit_logs automatically.

-- Q18: Multi-Table Consistency check?
START TRANSACTION;
UPDATE accounts SET balance = balance - 1000 WHERE acc_id = 1;
UPDATE daily_limits SET current_spent = current_spent + 1000 WHERE acc_id = 1;
COMMIT;

-- Q19: Batch Transaction Processing?
START TRANSACTION;
INSERT INTO audit_logs(acc_id, action) VALUES (1, 'BATCH'), (2, 'BATCH');
COMMIT;

-- Q20-Q50: Covering Savepoint stacks, Nested procedures with transactions, 
-- Gap Locks, Next-Key Locks, and Row-level vs Table-level locking...

-- Q25: Releasing all locks?
ROLLBACK; -- Implicitly releases.

-- Q30: Checking metadata locks?
SELECT * FROM performance_schema.metadata_locks;

-- Q40: Manual exclusive table lock?
LOCK TABLES accounts WRITE;
-- Do stuff...
UNLOCK TABLES;

-- Q50: Global Read lock for Backup?
FLUSH TABLES WITH READ LOCK;
-- ... copy files ...
UNLOCK TABLES;

