-- Test 4: Transactions — ACID Properties

-- ACID: Atomicity, Consistency, Isolation, Durability
-- Rule: Either ALL operations succeed, or NONE of them do.

START TRANSACTION;

-- Step 1: Deduct from sender
UPDATE accounts SET balance = balance - 1000 WHERE user_id = 1;
-- Step 2: Add to receiver
UPDATE accounts SET balance = balance + 1000 WHERE user_id = 2;

-- If Step 2 fails, ROLLBACK undoes Step 1 too
ROLLBACK;  -- Undo everything if anything fails

-- If all good:
COMMIT;    -- Make changes permanent

-- Java Spring equivalent:
-- @Transactional  -- Spring does START TRANSACTION / COMMIT / ROLLBACK automatically!
-- public void transfer(int from, int to, double amount) {
--   deduct(from, amount);  // If this throws exception, Spring calls ROLLBACK
--   credit(to, amount);
-- }
